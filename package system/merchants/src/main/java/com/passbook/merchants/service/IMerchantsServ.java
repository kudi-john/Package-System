package com.passbook.merchants.service;

import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;

//对商户服务接口定义
public interface IMerchantsServ {
    //创建商户服务
    Response createMerchants(CreateMerchantsRequest request);
    //根据ID构造商户信息
    Response buildMerchantsInfoById(Integer id);
    //投放优惠券
    Response dropPassTemplate(PassTemplate template);
}
