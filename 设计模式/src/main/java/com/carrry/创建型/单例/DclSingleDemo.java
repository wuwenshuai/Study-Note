package com.carrry.创建型.单例;


/**
 * 双重检测锁
 */
public class DclSingleDemo {

    private static volatile DclSingleDemo dclSingleDemo = null;

    private DclSingleDemo() {

    }


    public static DclSingleDemo getInstance() {
        if (dclSingleDemo == null) {
            synchronized (DclSingleDemo.class) {
                if (dclSingleDemo == null) {
                    dclSingleDemo=  new DclSingleDemo();
                }
            }
        }
        return dclSingleDemo;
    }
    public static void main(String[] args) {
        DclSingleDemo dclSingleDemo1 = DclSingleDemo.getInstance();
        DclSingleDemo dclSingleDemo2 = DclSingleDemo.getInstance();
        System.out.println(dclSingleDemo1==dclSingleDemo2);
    }
}
