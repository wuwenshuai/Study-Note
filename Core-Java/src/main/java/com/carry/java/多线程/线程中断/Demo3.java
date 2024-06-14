package com.carry.java.多线程.线程中断;

public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true){
                // 获取任务
                // 拿到任务，执行任务
                // 没有任务了，让线程休眠
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("基于打断形式结束当前线程");
                    return;
                }
            }
        });
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();
    }


}
