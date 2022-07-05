package com.carry.java.字符串;

/**
 * @author cw3k
 * @version 1.0
 * @description: 多继承如果两个接口的方法相同，即使是默认方法，子类一定要重写这个方法，不然会编译报错的
 *
 * java只能要求是单继承的原因是：如果支持多继承的话，如果有两个父类的方法一样，之类是可以调用父类的方法，如果这样之类就不知道用哪个方法了
 * @date 2022/6/21 14:08
 */
public class TestAB implements A,B {
    @Override
    public void testA() {

    }

    @Override
    public void testB() {

    }


}
