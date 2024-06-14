package com.carry.java.多线程.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/3/3 16:10
 */
public class Demo1 {


    public static  final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    Date parse = SIMPLE_DATE_FORMAT.parse("2021-10-22");
                    System.out.println(parse);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
