package com.carry.java.多线程.大厂学院多线程.基础;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/2/8 14:23
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            Thread.sleep(4000);
            System.out.println("thread:"+Thread.currentThread().getName());

            return 1024;
        });

        new Thread(futureTask,"a").start();

        System.out.println("thread main:"+Thread.currentThread().getName()+"\t"+Thread.currentThread().isDaemon());
    }
}


