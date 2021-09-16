package com.carry.java.设计模式.模板方法;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/16 17:31
 */
public class BStudent extends AbstractCarModel{
    @Override
    protected void start() {
        System.out.println("B start-----");
    }

    @Override
    protected void stop() {
        System.out.println("B stop-----");
    }

    @Override
    protected void alarm() {
        System.out.println("B alarm-----");
    }

    @Override
    protected void engineBoom() {
        System.out.println("B engineBoom-----");
    }
}
