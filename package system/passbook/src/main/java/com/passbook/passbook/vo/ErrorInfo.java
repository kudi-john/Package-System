package com.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一的错误信息
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {
    //错误码
    public static final Integer ERROR = -1;
    //特定的错误码
    private int code;

    private String message;
    //错误url
    private String url;
    //请求返回的数据
    private T data;

}
