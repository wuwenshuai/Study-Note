package com.carrry.结构型.代理.动态;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkTiktokProxy<T>  implements InvocationHandler {



    private T target;  // 被代理对象
    JdkTiktokProxy(T target) {
        this.target = target;
    }

    public static<T> T getProxy(T t) {
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new JdkTiktokProxy<>(t));
        return (T) o;
    }


    /**
     * 定义目标方法的拦截逻辑，每个方法都会进来
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //反射执行
        System.out.println("真正执行被代理对象的方法");
        Object invoke = method.invoke(target, args);
        System.out.println("返回值：一堆美女");
        return invoke;
    }
}
