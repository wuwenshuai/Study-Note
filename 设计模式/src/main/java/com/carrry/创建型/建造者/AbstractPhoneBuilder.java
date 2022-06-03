package com.carrry.创建型.建造者;

public abstract class AbstractPhoneBuilder {


    Phone phone;

    abstract AbstractPhoneBuilder cpu(String cup);

    abstract AbstractPhoneBuilder mem(String cup);

    abstract AbstractPhoneBuilder disk(String disk);

    Phone getProduct(){
        return phone;
    }
}

