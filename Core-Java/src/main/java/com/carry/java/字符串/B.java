package com.carry.java.字符串;

public interface B {

    void testA();
    default void testB(){
        System.out.println("我是B的 testB");
    }
}
