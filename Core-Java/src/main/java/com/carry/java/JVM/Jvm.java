package com.carry.java.JVM;

import lombok.Data;
import org.openjdk.jol.info.ClassLayout;

public class Jvm {


    static User[] us =new  User[10];
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
         User user =new User();

         synchronized (user) {
             System.out.println(ClassLayout.parseInstance(user).toPrintable());
         }
    }
}





@Data
class User {
    private String name;


}
