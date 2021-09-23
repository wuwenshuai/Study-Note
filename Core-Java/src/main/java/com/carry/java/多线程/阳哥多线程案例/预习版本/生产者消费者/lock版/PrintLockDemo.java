package com.carry.java.多线程.阳哥多线程案例.预习版本.生产者消费者.lock版;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/23 14:24
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 备注：多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 * 1.高内聚低耦合前提下，线程操作资源类
 * 2.判断/干活/通知
 * 3.多线程交互中，防止虚假唤醒(判断只能用while，不能用if)
 * 4.标志位
 */

public class PrintLockDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.printc1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.printc2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();



        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.printc3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}

class ShareData {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void printc1() throws InterruptedException {
        try {
            lock.lock();
            while (number != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }

    }

    public void printc2() throws InterruptedException {
        try {
            lock.lock();
            while (number != 2) {
                c2.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printc3() throws InterruptedException {
        try {
            lock.lock();
            while (number != 3) {
                c3.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
