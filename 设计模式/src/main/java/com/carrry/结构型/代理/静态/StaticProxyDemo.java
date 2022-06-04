package com.carrry.结构型.代理.静态;

public class StaticProxyDemo {




    public static void main(String[] args) {

        ManTikTok manTikTok = new LeiTikTok();

        LiMingTiktokProxy proxy = new LiMingTiktokProxy(manTikTok);
        proxy.tiktok();

    }
}
