package com.carry.java.多线程.线程池;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/15 15:21
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread4 = new MyThread();
        MyThread myThread5 = new MyThread();
        MyThread myThread3 = new MyThread();

        executor.submit(myThread1);
        executor.submit(myThread2);
        executor.submit(myThread3);
        executor.submit(myThread4);
        executor.submit(myThread5);
        // 关闭线程池
        executor.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"正在执行....");
    }
}
