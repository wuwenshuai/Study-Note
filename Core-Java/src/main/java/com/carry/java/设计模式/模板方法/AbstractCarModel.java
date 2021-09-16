package com.carry.java.设计模式.模板方法;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/16 17:29
 */
public abstract class AbstractCarModel {
    protected abstract void start(); //发动
    protected abstract void stop();  //停止
    protected abstract void alarm(); //鸣笛
    protected abstract void engineBoom(); //轰鸣
    final public void  run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            System.out.println("用户自定义-----");
            this.alarm();
        }
        this.stop();
    }

    protected boolean isAlarm() { //我们加了一个判断方法，默认返回true
        return true;
    }

}
