package com.carrry.创建型.建造者;


/**
 * 产品角色Pone 抽象建造者 Builder  具体建造者： PhoneBuilder
 * 创建的东西细节复杂，还必须暴露给使用者，屏蔽过程而不屏蔽细节
 *
 * 什么场景能用到？StringBuilder
 */
public class BuilderDemo {

    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();

        Phone product = phoneBuilder.cpu("2").disk("64G").getProduct();
        System.out.println(product);
    }
}
