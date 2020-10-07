package com.passbook.passbook.service;

import com.passbook.passbook.vo.PassTemplate;

public interface IHBasePassService {
    //将passtemplate写入hbase
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
