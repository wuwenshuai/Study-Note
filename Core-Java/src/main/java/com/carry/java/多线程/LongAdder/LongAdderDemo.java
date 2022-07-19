package com.carry.java.多线程.LongAdder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {


    public static final int SIZE_THREAD = 50;
    public static final int _1w = 10000;

    public static void main(String[] args) throws InterruptedException {
        long start;

        long end;
        ClickNumber clickNumber = new ClickNumber();
        CountDownLatch countDownLatch2 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch1 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch3 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch4 = new CountDownLatch(SIZE_THREAD);




        start = System.currentTimeMillis();
        for (int i = 1; i <= SIZE_THREAD; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * _1w; j++) {
                        clickNumber.add3();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch1.countDown();
                }
            }, String.valueOf(i)).start();
        }

        countDownLatch1.await();

        end = System.currentTimeMillis();

        System.out.println("----costTime: " + (end - start) + " 毫秒" + "\t add_Synchronized" + "\t" + clickNumber.LongAdder);


    }
}


class ClickNumber {
    int num = 0;

    public synchronized void add() {
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void add1() {
        atomicInteger.incrementAndGet();
    }


    AtomicLong AtomicLong = new AtomicLong();

    public void add2() {
        AtomicLong.incrementAndGet();
    }

    LongAdder LongAdder = new LongAdder();

    public void add3() {
        LongAdder.increment();
        LongAdder.sum();
    }

}
