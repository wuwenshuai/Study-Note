package com.carrry.创建型.工厂.简单工厂;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        DeliverController deliverController = new DeliverController();
        //2. 发放优酷会员
        AwardInfo info2 = new AwardInfo();
        info2.setUid("1002");
        info2.setAwardType(2);
        info2.setAwardNumber("DW12345");
        Map<String,String> map = new HashMap<>();
        map.put("phone","13512341234");
        info2.setExtMap(map);

        ResponseResult result1 = deliverController.awardToUser(info2);
        System.out.println(result1);




    }
}
