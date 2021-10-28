package com.carry.java.IO;

public class Io {


    public static void main(String[] args) {


        Object o = new Object();
        int i = o.hashCode();
        System.out.println(i);
        System.out.println(i & Integer.MAX_VALUE);
        String a = "1122333";
        System.out.println(a.substring(0, 3));
    }
}
