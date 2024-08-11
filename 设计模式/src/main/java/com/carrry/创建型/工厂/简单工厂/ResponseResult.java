package com.carrry.创建型.工厂.简单工厂;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ResponseResult {

    private String status; // 状态码
    private String message; // 信息

    private Object data;

    public ResponseResult(String status, String message){
        this.status = status;
        this.message = message;
    }
}