package com.carry.java.字符串;

public interface A {
    void testA();
    default void testB(){
        System.out.println("我是A的 testB");
    }
}
