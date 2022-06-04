package com.carrry.结构型.代理.cglib;

public class CglibProxyDemo {

    public static void main(String[] args) {

        LeiTikTok proxy = CglibProxy.createProxy(new LeiTikTok());
        proxy.tiktokHaha();
    }
}
