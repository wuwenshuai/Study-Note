package com.carry.java.多线程.大厂学院多线程.基础;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/2/8 14:23
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        // futuretask :主线程想要子线程做事情
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            Thread.sleep(4000);
            System.out.println("thread:"+Thread.currentThread().getName());

            return 1024;
        });

        new Thread(futureTask,"a").start();

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();


        
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("-------");
        });
        CompletableFuture.runAsync(() -> {
            System.out.println("----www---");
        });

        System.out.println("thread main:"+Thread.currentThread().getName()+"\t"+Thread.currentThread().isDaemon());
    }
}


