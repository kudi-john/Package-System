package com.passbook.passbook.service;

import com.passbook.passbook.vo.Response;
import com.passbook.passbook.vo.User;

//创建user服务
public interface IUserService {
    //创建用户
    Response createUser(User user) throws Exception;
}
