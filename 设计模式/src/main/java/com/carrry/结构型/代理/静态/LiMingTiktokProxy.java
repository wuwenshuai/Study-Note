package com.carrry.结构型.代理.静态;

public class LiMingTiktokProxy implements  ManTikTok {


    private ManTikTok manTikTok;  //被代理对象
    public LiMingTiktokProxy(ManTikTok manTikTok){
        this.manTikTok = manTikTok;
    }


    @Override
    public void tiktok() {
        //增强功能
        System.out.println("渲染直播间....");
        System.out.println("课程只要666，仅此一天....");
        manTikTok.tiktok();
    }
}
