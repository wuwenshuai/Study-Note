package com.carry.java.多线程.阳哥多线程案例.预习版本.生产者消费者.lock版;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/23 13:54
 */
public class ProdConsumerLockDemo {

    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airCondition.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airCondition.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class AirCondition{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static Integer number = 0;


    public  void increment() throws InterruptedException {
       try {
           lock.lock();
           while (number != 0) {
               condition.await();
           }
           number++;
           System.out.println(Thread.currentThread().getName()+"\t"+number);
           condition.signalAll();
       }finally {
           lock.unlock();
       }
    }

    public void decrement() throws InterruptedException {
        try {
            lock.lock();
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}



