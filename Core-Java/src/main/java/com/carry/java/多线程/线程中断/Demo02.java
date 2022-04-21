package com.carry.java.多线程.线程中断;


import java.util.concurrent.TimeUnit;

public class Demo02 {

    public static void main(String[] args) throws InterruptedException {

        //作用是测试当前线程是否被中断（检查中断标志），
        // 返回一个 boolean 并清除中断状态，  
        // 第二次再调用时中断状态已经被清除，将返回一个 false
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println("111111");
        Thread.currentThread().interrupt();  ////false----true
        System.out.println("222222");
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
    }

    /**
     * 中断标识位的阻塞清除
     *
     * @throws InterruptedException
     */
    private static void m6() throws InterruptedException {
        Thread t1 = new Thread(() -> {

            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("isInterrupted = true,程序结束---");
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //再掉一次
                    e.printStackTrace();
                }
                System.out.println("---hello interrupt");
            }

        }, "t1");
        t1.start();

        TimeUnit.SECONDS.sleep(3);
        new Thread(() -> {
            t1.interrupt();  // 修改t1的线程中断标识为true
        }, "t2").start();
    }

    /**
     * t1.interrupt 不会立刻中断线程的案例
     *
     * @throws InterruptedException
     */
    private static void m5() throws InterruptedException {
        /**
         * t1.interrupt 方法，会把中断标志设置为true，但是不会立刻停止线程
         */
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.println("-----------" + i);
            }
        }, "t1");

        t1.start();

        System.out.println("before t1.interrupt:" + t1.isInterrupted());
        // 设置中断标识，但是不会立刻停止线程
        t1.interrupt();

        //活动状态，t1线程还在执行中
        TimeUnit.MILLISECONDS.sleep(3);
        System.out.println("after t1.interrupt-01:" + t1.isInterrupted());

        //非活动状态，t1线程不在执行中，已经结束执行了
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("after t1.interrupt-02:" + t1.isInterrupted());
    }
}
