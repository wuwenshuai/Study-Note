package com.carry.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor(){
        System.out.println("MyBeanPostProcessor implements BeanPostProcessor ...");
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor...postProcessBeforeInitialization..."+bean+"==>"+beanName);
        return bean; // new Object();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor...postProcessAfterInitialization..."+bean+"==>"+beanName);
        return bean;
    }
}
