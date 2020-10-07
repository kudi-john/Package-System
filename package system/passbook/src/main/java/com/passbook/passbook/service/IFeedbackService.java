package com.passbook.passbook.service;

import com.passbook.passbook.vo.Feedback;
import com.passbook.passbook.vo.Response;
//评论功能实现
public interface IFeedbackService {
    //创建评论
    Response createFeedback(Feedback feedback);
    //获取用户评论
    Response getFeedback(Long userId);
}
