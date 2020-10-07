package com.passbook.passbook.constant;
//优惠券的状态
public enum PassStatus {
    UNUSED(1,"未被使用的"),
    USED(2,"已经使用的"),
    ALL(3,"全部领取的");

    private Integer code;//状态吗

    private String desc;//状态描述

    PassStatus(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
