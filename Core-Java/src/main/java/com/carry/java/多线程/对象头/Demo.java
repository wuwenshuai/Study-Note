package com.carry.java.多线程.对象头;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/3/5 7:37
 */
public class Demo {
    public static void main(String[] args) {


        Object o = new Object();
        // 实例对象 = 对象头 + 实例数据 + 对齐填充
        // 对象头 = 对象标记markword + 类型指针(类元信息) + 长度（数组独有）
        // 实例数据 = instance data
        // 对齐填充 :保证八个字节的倍数

    }
}
