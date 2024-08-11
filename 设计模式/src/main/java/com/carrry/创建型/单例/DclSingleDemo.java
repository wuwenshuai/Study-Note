package com.carrry.创建型.单例;


import java.lang.reflect.Constructor;


/**
 * 双重检测锁
 */
public class DclSingleDemo {

    private static volatile DclSingleDemo dclSingleDemo = null;

    private static boolean isInit = false;

    private DclSingleDemo() {

        if (dclSingleDemo != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
        isInit = true;
    }


    public static DclSingleDemo getInstance() {
        if (dclSingleDemo == null) {
            synchronized (DclSingleDemo.class) {
                if (dclSingleDemo == null) {
                    dclSingleDemo = new DclSingleDemo();
                    // 为啥dclSingleDemo 要加volatile ？
                    // 因为dclSingleDemo 是一个对象，在创建的时候，会先创建一个对象，然后初始化对象，最后再把对象赋值给dclSingleDemo
                    /**
                     * 1.分配内存空间
                     * 2.初始化
                     * 3.将内存地址赋值给dclSingleDemo
                     *
                     * JVM可能进行指令重排, 导致dclSingleDemo对象还没有初始化完成，就被其他线程获取到，然后进行初始化，然后进行赋值  1 3 2
                     * 这个时候1 和 3 是可以同时执行的，然后2执行完，dclSingleDemo对象还没有初始化完成，但是不是null了，就被其他线程获取到，然后进行初始化，然后进行赋值
                     */
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


        //序列化对单利的影响


    }
}
