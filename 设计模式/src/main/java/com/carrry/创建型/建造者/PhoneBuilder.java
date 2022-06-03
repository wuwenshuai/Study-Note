package com.carrry.创建型.建造者;

public class PhoneBuilder extends AbstractPhoneBuilder{


    public PhoneBuilder() {

        phone =new Phone();
    }

    @Override
    AbstractPhoneBuilder cpu(String cup) {
        phone.cpu =cup;
        return this;
    }

    @Override
    AbstractPhoneBuilder mem(String mem) {
        phone.mem =mem;
        return this;
    }

    @Override
    AbstractPhoneBuilder disk(String disk) {
        phone.disk =disk;
        return this;
    }
}
