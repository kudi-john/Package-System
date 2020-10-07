package com.passbook.merchants.vo;

import com.passbook.merchants.constant.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//投放的优惠券对象定义
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {
    private Integer id;

    private String title;

    private String summary;

    private String desc;

    private Long limit;

    private boolean hasToken;  //token存储于redis set中，每次都可以从redis中获取

    private Integer background; //背景色

    private Date start;

    private Date end;

    public ErrorCode validate(MerchantsDao merchantsDao){
        if(null == merchantsDao.findById(id)){
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }else{
            return ErrorCode.SUCCESS;
        }
    }

}
