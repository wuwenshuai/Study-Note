package com.carry.java.多线程.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/3/3 16:21
 */
public class Demo2 {

    public static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) throws ParseException {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"-"+parse("2021-10-22"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }finally {
                    SIMPLE_DATE_FORMAT_THREAD_LOCAL.remove();
                }
            }).start();
        }
    }

    public  static final Date parse(String s) throws ParseException {
        return SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().parse(s);
    }
}
