package com.carrry.创建型.工厂.简单工厂;

import lombok.Data;

import java.util.Map;



@Data
public class AwardInfo {

    private String uid; //用户唯一ID

    private Integer awardType; //奖品类型: 1 打折券 ,2 优酷会员,3 小礼品

    private String awardNumber; //奖品编号

    Map<String, String> extMap; //额外信息
    
}