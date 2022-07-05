package com.carry.java.多线程.线程池;



import java.util.concurrent.*;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/6/15 13:52
 */
public class ThreadPool {

    private ExecutorService queryPool = Executors.newFixedThreadPool(2000);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2000);
        executorService.submit(() -> {
            System.out.println("0000000000000000");
        });
    }


}
