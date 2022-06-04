package com.carrry.结构型.装饰者;


/**
 * 美颜装饰器
 * 装饰器只增强这个类的方法
 */
public class MeiYanDecorator implements  TiktokDecorator {

    private ManTikTok manTikTok;
    public MeiYanDecorator(ManTikTok manTikTok){
        this.manTikTok = manTikTok;
    }

    @Override
    public void enable() {
        System.out.println("看这个美女.....");
        System.out.println("花花花花花花花花花花花");
    }

    @Override
    public void tiktok() {

        //开启美颜
        enable();
        //开始直播
        manTikTok.tiktok();
    }
}
