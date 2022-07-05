package com.carrry.创建型.单例;


import java.lang.reflect.Constructor;


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
                    dclSingleDemo = new DclSingleDemo();
                }
            }
        }
        return dclSingleDemo;
    }

    public static void main(String[] args) throws Exception {
        DclSingleDemo dclSingleDemo1 = DclSingleDemo.getInstance();
        DclSingleDemo dclSingleDemo2 = DclSingleDemo.getInstance();
        System.out.println(dclSingleDemo1 == dclSingleDemo2);

        // 通过反射破坏单例
        DclSingleDemo instance = DclSingleDemo.getInstance();
        // 通过反射得到其构造函数,并修改其构造方法的访问权限
        Constructor<DclSingleDemo> constructor = DclSingleDemo.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        DclSingleDemo instance23 =  constructor.newInstance();
        System.out.println(instance == instance23);
    }
}
