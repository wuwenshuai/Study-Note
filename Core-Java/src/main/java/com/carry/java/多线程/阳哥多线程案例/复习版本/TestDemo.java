package com.carry.java.多线程.阳哥多线程案例.复习版本;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2021/9/23 10:55
 */
public class TestDemo {

    private static final String a = "he";

    public static void main(String[] args) {


        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        List<String> list = Arrays.asList("a", "b", "c");
        String collect = list.stream().collect(Collectors.joining());

        String string2 = list.stream().collect(Collectors.joining(","));
        System.out.println(string2);

        LongAdder longAdder = new LongAdder();
        longAdder.increment();

        ConcurrentHashMap<String, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<String, Object>(1,0.72f);
        objectObjectConcurrentHashMap.size();
    }
}
