package com.carry.java.多线程.阳哥多线程案例.预习版本.创建线程的方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/25 8:18
 */
public class CallThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new A());

        new Thread(futureTask).start();
        if (!futureTask.isDone()) {
            Integer o = futureTask.get();
            Integer integer = futureTask.get();
            System.out.println("integer"+integer);
            System.out.println(o);
        }

        System.out.println("我i是man");

    }
}


class A implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("我是callable--------");
        Thread.sleep(3000);
        return 1;
    }
}
