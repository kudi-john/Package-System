package com.passbook.merchants.vo;
//创建商户响应对象


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {
    //  商户ID：创建失败则为-1
    private Integer id;


}
