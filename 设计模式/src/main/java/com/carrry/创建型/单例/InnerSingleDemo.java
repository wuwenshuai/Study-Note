package com.carrry.创建型.单例;

/**
 * 静态内部类的：
 * 根据静态内部类的特性：在装载的时候才会被加载
 */
public class InnerSingleDemo {

    private static InnerSingleDemo singleDemo = null;

    static  class Inner{

        public static InnerSingleDemo getInstance() {
            if (InnerSingleDemo.singleDemo == null) {
                InnerSingleDemo.singleDemo = new InnerSingleDemo();
            }
            return  InnerSingleDemo.singleDemo;
        }
    }
    public static void main(String[] args) {
        InnerSingleDemo instance = Inner.getInstance();
        InnerSingleDemo instance1 = Inner.getInstance();
        System.out.println(instance.hashCode() == instance1.hashCode());
    }
}
