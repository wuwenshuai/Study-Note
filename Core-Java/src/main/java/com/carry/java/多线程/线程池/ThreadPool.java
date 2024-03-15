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

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println(Runtime.getRuntime().availableProcessors());



/**
 * int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue
 */

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 2000L, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(10)
                , r -> {
                    Thread thread = new Thread(r);
                    thread.setName("test-thread");
                    return thread;
                }, new MyRejectExec());
        // 让线程池处理没有返回结果的
        threadPoolExecutor.execute(() -> {
            System.out.println("没有返回结果的任务 ");
        });
        
        //让线程池处理有返回结果的
        Future<Object> future = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "我有返回结果";
            }
        });
        Object result = future.get();
        System.out.println(result);
        //如果是局部的线程池，需要调用shutDown
        threadPoolExecutor.shutdown();
    }


    private static class MyRejectExec implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    }


}
