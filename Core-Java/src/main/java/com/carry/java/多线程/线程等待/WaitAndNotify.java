package com.carry.java.多线程.线程等待;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class WaitAndNotify {


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 被唤醒");
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" 发出通知----");
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();
    }

    private static void m2() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+" come in");
                try {
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+" 被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }

        },"t1").start();
        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+" 发出通知----");
            }finally {
                lock.unlock();
            }

        },"t2").start();
    }


    /**
     * wait
     */
    private static void m1() {
        Object objectLock = new Object();  // 同一把锁

        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName()+"come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"被唤醒");
            }
        },"t1").start();


        new Thread(() -> {
          synchronized (objectLock) {
              objectLock.notify();
              System.out.println(Thread.currentThread().getName()+"发出唤醒通知");
          }
        },"t2").start();
    }


}
