package com.carry.java.多线程.AQS.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {

        // AQS共享锁
        Semaphore semaphore =new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Car(i,semaphore).start();
        }
    }



    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;


        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }


        @Override
        public void run() {
            try {
                semaphore.acquire();// 获得一个令牌
                System.out.println("第"+num+" 抢占一个车位");
                Thread.sleep(2000);
                System.out.println("第"+num+" 车开走了");
                semaphore.release();

                System.out.println("=================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
