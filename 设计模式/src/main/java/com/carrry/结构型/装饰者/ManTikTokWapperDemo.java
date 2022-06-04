package com.carrry.结构型.装饰者;

public class ManTikTokWapperDemo {

    public static void main(String[] args) {



        ManTikTok manTikTok = new LeiTikTok();
        MeiYanDecorator meiYanDecorator = new MeiYanDecorator(manTikTok);
        meiYanDecorator.tiktok();
    }
}
