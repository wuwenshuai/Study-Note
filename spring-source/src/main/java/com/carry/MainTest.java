package com.carry;

import com.carry.bean.Cat;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Cat bean = context.getBean(Cat.class);
        System.out.println(bean);
    }
}
