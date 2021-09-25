package com.carry.java.多线程.阳哥多线程案例.预习版本.线程中断;

/**
 * @author cw3k
 * @version 1.0
 * @description: 中断一个线程的方式
 * @date 2021/9/25 8:55
 */
public class InterruptThread {


    private static  int i;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {



           while (true) {
               if (Thread.currentThread().isInterrupted()) {

                   System.out.println("before:"+Thread.currentThread().isInterrupted());
                   Thread.interrupted();
                   System.out.println("after:"+Thread.currentThread().isInterrupted());
//                i++;
//                System.out.println("num:" + i);
//                Thread.interrupted();
               }
           }
        }, "InterruptThread");

        thread.start();


        Thread.sleep(100);
        thread.interrupt();

    }
}
