package com.carry.java.多线程.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程A---------");
                TimeUnit.MINUTES.sleep(300000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();


        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程B---------");

            } finally {
                lock.unlock();
            }
        }, "B").start();


        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程C---------");

            } finally {
                lock.unlock();
            }
        }, "C").start();


    }
}
