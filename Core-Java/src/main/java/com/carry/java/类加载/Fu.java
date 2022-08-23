package com.carry.java.类加载;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/8/23 14:49
 */
public class Fu{

    {
        System.out.println("Fu 类的代码块");
    }

    static {
        System.out.println("Fu 类的Static代码块");
    }

    public Fu() {
        System.out.println("Fu 类的构造方法");
    }
}
