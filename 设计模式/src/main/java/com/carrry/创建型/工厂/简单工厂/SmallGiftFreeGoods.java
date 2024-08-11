package com.carrry.创建型.工厂.简单工厂;

import java.util.UUID;

/**
 * 小礼品发放服务
 * @author spikeCong
 * @date 2022/9/8
 **/
public class SmallGiftFreeGoods implements IFreeGoods {

    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {

        SmallGiftInfo smallGiftInfo = new SmallGiftInfo();
        smallGiftInfo.setUserPhone(awardInfo.getExtMap().get("phone"));
        smallGiftInfo.setUserName(awardInfo.getExtMap().get("username"));

        smallGiftInfo.setOrderId(UUID.randomUUID().toString());

        System.out.println("小礼品发放成,请注意查收: ");
        return new ResponseResult("200","小礼品发送成功",smallGiftInfo);
    }
}