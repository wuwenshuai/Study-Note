package com.carry.java.多线程.大厂学院多线程.基础;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/2/10 10:07
 */
public class FutureTaskDemo {

    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(() -> {


            System.out.println(11);
            return 1;
        });


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);

        executorService.shutdown();

    }
}
