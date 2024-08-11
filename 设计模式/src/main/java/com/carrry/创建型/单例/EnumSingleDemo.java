package com.carrry.创建型.单例;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingleDemo {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingleDemo instance1 = EnumSingleDemo.INSTANCE;
        EnumSingleDemo instance2 = EnumSingleDemo.INSTANCE;
        System.out.println(instance1 == instance2);

        Class<EnumSingleDemo> enumSingleDemoClass = EnumSingleDemo.class;
        try {
            Constructor<EnumSingleDemo> declaredConstructor =
                    enumSingleDemoClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            EnumSingleDemo instance3 = declaredConstructor.newInstance();

            System.out.println(instance1 == instance3);
        } catch (NoSuchMethodException e) {
            //这个错误表明在尝试使用反射调用EnumSingleDemo的私有构造函数时，找不到该构造函数。
            // 这可能是因为枚举类型（Enum）的构造函数访问控制符不能是私有的
            // 。尝试将EnumSingleDemo的构造函数访问控制符更改为默认（包私有）或公共（public），然后重新运行代码
            throw new RuntimeException(e);
        }

    }
}
