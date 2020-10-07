package com.passbook.passbook.utils;

import com.passbook.passbook.vo.Feedback;
import com.passbook.passbook.vo.GainPassTemplateRequest;
import com.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * <h1>RowKey 生成器工具类</h1>
 * 生成RowKey，使用Hbase进行存储
 */
@Slf4j
public class RowKeyGenUtil {
    /**
     * <h2>根据提供的 PassTemplate 对象生成 RowKey</h2>
     * @param passTemplate {@link PassTemplate}
     * @return String RowKey
     * */
    public static String genPassTemplateRowKey(PassTemplate passTemplate) {
        String passInfo = String.valueOf(passTemplate.getId()) + "_" + passTemplate.getTitle();
        String rowKey = DigestUtils.md5Hex(passInfo);//使用md5使得rowkey更为分散，便于Hbase分布式存储
        log.info("GenPassTemplateRowKey: {}, {}", passInfo, rowKey);
        return rowKey;
    }
    /**
     * <h2>根据提供的领取优惠券请求生成 RowKey, 只可以在领取优惠券的时候使用</h2>
     * Pass RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     * @param request {@link GainPassTemplateRequest}
     * @return String RowKey
     * */
    public static String genPassRowKey(GainPassTemplateRequest request) {
        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }
    /**
     * <h2>根据 Feedback 构造 RowKey</h2>
     * @param feedback {@link Feedback}
     * @return String RowKey
     * */
    public static String genFeedbackRowKey(Feedback feedback) {
        //因为userID前缀都相似，而后缀有区别，然而我们要求不同的用户的rowKey越不同越好，因此翻转一下，使得数字的区分度增大
        //而long max减去当前时间为了让后面创建的feedback排在前面，当前时间越大被减后越小，越排前面
        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }
}
