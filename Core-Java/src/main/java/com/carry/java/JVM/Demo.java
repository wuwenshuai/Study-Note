package com.carry.java.JVM;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/3/5 8:10
 */
public class Demo {

    public static void main(String[] args) {


       // System.out.println(VM.current().details());
       // System.out.println(VM.current().objectAlignment());

        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(new MyObj()).toPrintable());
    }
}

class MyObj {
    int a = 1;
    boolean b = false;
}
