package com.carry.java.多线程.AQS.coundownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {

            System.out.println("thread 2");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 3");
            countDownLatch.countDown();
        }).start();

       countDownLatch.await(3, TimeUnit.SECONDS);

        System.out.println("jjjjjj");

    }
}
