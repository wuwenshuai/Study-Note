package com.carry.java.集合;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {

    public static void main(String[] args) {

        Map map = new HashMap<>();

        Object o1 = new Object();
        Object o2 = o1;

        map.put(o1,"1");
        System.out.println(1111);
        System.out.println(map.get(o2));
    }
}
