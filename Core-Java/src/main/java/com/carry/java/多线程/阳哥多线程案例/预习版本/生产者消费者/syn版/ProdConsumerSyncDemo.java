package com.carry.java.多线程.阳哥多线程案例.预习版本.生产者消费者.syn版;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/23 11:22
 */
/**
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量-1，
 * 实现交替，来10轮，变量初始值为0.
 *      1.高内聚低耦合前提下，线程操作资源类
 *      2.判断/干活/通知
 *      3.防止虚假唤醒(判断只能用while，不能用if)
 * 知识小总结：多线程编程套路+while判断+新版写法
 */

public class ProdConsumerSyncDemo {

    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airCondition.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airCondition.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class AirCondition {

    private static Integer number = 0;

    /**
     * 加1
     */
    public synchronized void increment() throws InterruptedException {
        // 1.判断
        while (number != 0) {
            this.wait();
        }
        // 2.干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3 通知
        this.notifyAll();
    }


    /**
     * 减一
     */
    public synchronized void decrement() throws InterruptedException {

        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }

}




