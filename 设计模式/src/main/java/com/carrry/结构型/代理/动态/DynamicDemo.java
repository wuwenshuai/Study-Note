package com.carrry.结构型.代理.动态;

public class DynamicDemo {
    public static void main(String[] args) {

        ManTikTok manTikTok = new LeiTikTok();
        ManTikTok proxy = JdkTiktokProxy.getProxy(manTikTok);
        proxy.tiktok();

    }
}
