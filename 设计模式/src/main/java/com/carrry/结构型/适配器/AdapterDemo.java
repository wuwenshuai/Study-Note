package com.carrry.结构型.适配器;


/**
 *
 * 将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，
 * 适配器模式分为类结构型模式（继承）和对象结构型模式（组合）两种，前者（继承）类之间的耦合度比后者高，
 * 且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
 * 别名也可以是Wrapper，包装器
 *
 *
 * 适配器模式（Adapter）包含以下主要角色。
 * 目标（Target）接口：可以是抽象类或接口。客户希望直接用的接口
 * 适配者（Adaptee）类：隐藏的转换接口
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口。
 */
public class AdapterDemo {

    public static void main(String[] args) {
        Player player = new MoviePlayer();
        JPMovieAdapter jpMovieAdapter = new JPMovieAdapter(player);
        jpMovieAdapter.play();
    }
}
