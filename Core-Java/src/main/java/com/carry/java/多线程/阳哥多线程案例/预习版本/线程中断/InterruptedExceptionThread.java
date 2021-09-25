package com.carry.java.多线程.阳哥多线程案例.预习版本.线程中断;

/**
 * @author cw3k
 * @version 1.0
 * @description: 抛出异常对
 * @date 2021/9/25 10:10
 */
public class InterruptedExceptionThread {


    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (true) {
                //
                try {
                    Thread.sleep(1000); //中断一个阻塞的线程，会抛出一个异常
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                //  System.out.println("I:"+i++);

            }


        }, "A");

        thread.start();
        Thread.sleep(1000);
        thread.interrupt(); // 中断线程 从false--->true

        System.out.println(thread.isInterrupted());
    }
}
