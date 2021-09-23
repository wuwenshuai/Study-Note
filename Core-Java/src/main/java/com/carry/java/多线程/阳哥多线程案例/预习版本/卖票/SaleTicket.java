package com.carry.java.多线程.阳哥多线程案例.预习版本.卖票;

/**
 * @author cw3k
 * @version 1.0
 * @description: 三个售票员卖出 30张票
 * @date 2021/9/23 11:00
 */


public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"A").start();


        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"B").start();


        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"C").start();
    }
}


/**
 * 资源类
 */


class Ticket{

    private static int number = 30;

    // 卖票
    public synchronized void saleTicket() {
        if (number > 0) {
            System.out.println("线程："+Thread.currentThread().getName()+"卖出了第"+number+"张票  "+"还剩下:"+(--number)+"张票");
        }
    }
}
