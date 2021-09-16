package com.carry.java.多线程.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/15 15:21
 */
public class ThreadPoolInVokeAll {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new MyThread2());
        }
        try {
            List<Future<Void>> futures = executor.invokeAll(tasks);
            System.out.println(futures);
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
        // 关闭线程池
        executor.shutdown();
    }
}

class MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        long l = System.currentTimeMillis();

        if (l % 2 == 0) {
            System.out.println("运行时异常------------");
            throw new RuntimeException("运行时异常");
        } else {
            System.out.println("没有异常------------");
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"正在执行....");
        return Thread.currentThread().getId();
    }
}
