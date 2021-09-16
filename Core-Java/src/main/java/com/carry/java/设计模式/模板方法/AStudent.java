package com.carry.java.设计模式.模板方法;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/16 17:31
 */
public class AStudent  extends AbstractCarModel{


    private boolean alarmFlag = true; //判断标记


    @Override
    protected void start() {
        System.out.println("A start-----");
    }

    @Override
    protected void stop() {
        System.out.println("A stop-----");
    }

    @Override
    protected void alarm() {
        System.out.println("A alarm-----");
    }

    @Override
    protected void engineBoom() {
        System.out.println("A engineBoom-----");
    }

    @Override
    protected boolean isAlarm() { //覆写isAlarm方法，返回判断标记
        return false;
    }

}
