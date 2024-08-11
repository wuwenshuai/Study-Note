package com.carrry.创建型.工厂.简单工厂;

public class DeliverController {

    //发放奖品
    public ResponseResult awardToUser(AwardInfo awardInfo){

        try {
            IFreeGoods freeGoods = FreeGoodsFactory.getInstance(awardInfo.getAwardType());
            ResponseResult responseResult = freeGoods.sendFreeGoods(awardInfo);
            return responseResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult("201","奖品发放失败!");
        }
    }
}