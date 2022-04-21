package com.carry.java.多线程.线程中断;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {


    static volatile boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().interrupted()) {
                    System.out.println("is stop == true");
                    break;
                } else {
                   // System.out.println("hello");
                }
            }
        });
        t1.start();


        System.out.println("before*****"+t1.isInterrupted());  //false

        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(() -> {
            t1.interrupt(); // 修改t1线程的中断标识为true
        });
        t2.start();


        System.out.println("after*****"+t1.isInterrupted());  //true
    }

    /**
     * interrupt方式
     * @throws InterruptedException
     */
    private static void m2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().interrupted()) {
                    System.out.println("is stop == true");
                    break;
                } else {
                    System.out.println("hello");
                }
            }
        });
        t1.start();


        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(() -> {
            t1.interrupt(); // 修改t1线程的中断标识为true
        });
        t2.start();
    }

    /**
     * 通过一个volatile变量实现
     * @throws InterruptedException
     */
    private static void m1() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println("is stop == true");
                } else {
                    System.out.println("hello");
                }
            }
        }).start();


        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            isStop = true;
        }).start();
    }


}
