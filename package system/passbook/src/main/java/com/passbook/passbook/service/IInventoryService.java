package com.passbook.passbook.service;

import com.passbook.passbook.vo.Response;

//获取库存信息：只返回用户没有领取的优惠券，即实现优惠券库存功能接口
public interface IInventoryService {
    //获取库存信息
    Response getInventoryInfo(Long userId) throws Exception;
}
