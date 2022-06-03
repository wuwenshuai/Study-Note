package com.carrry.创建型.建造者;

public class Phone {
    String cpu;
    String disk;
    String mem;


    public String getCpu() {
        return cpu;
    }

    public String getDisk() {
        return disk;
    }

    public String getMem() {
        return mem;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", disk='" + disk + '\'' +
                ", mem='" + mem + '\'' +
                '}';
    }
}
