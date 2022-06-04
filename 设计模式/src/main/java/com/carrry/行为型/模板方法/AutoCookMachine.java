package com.carrry.行为型.模板方法;

public class AutoCookMachine extends CookTemplate {
    @Override
    public void addfood() {
        System.out.println("放辣白菜----");
    }

    @Override
    public void addsalt() {
        System.out.println("可以放盐了---");
    }
}
