package com.passbook.merchants.constant;

public enum ErrorCode {
    SUCCESS(0,""),
    DUPLICATE_NAME(2,"商户名称重复"),
    EMPTY_LOGO(2,"商户logo为为空"),
    EMPTY_BUSINESS_LICENSE(3,"商户营业执照为空"),
    ERROR_PHONE(4,"商户电话错误"),
    EMPTY_ADDRESS(5,"商户地址为空"),
    MERCHANTS_NOT_EXIST(6,"商户不存在");

    private Integer code;
    private String desc;

    ErrorCode(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
