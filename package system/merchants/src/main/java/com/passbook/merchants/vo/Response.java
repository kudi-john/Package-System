package com.passbook.merchants.vo;
//通用响应对象

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Integer errorCode;//正确返回0

    private String errorMsg = ""; //正确返回空""

    private Object data;

    public Response(Object data){
        this.data = data;
    }

}
