package com.passbook.passbook.service;

import com.alibaba.fastjson.JSON;
import com.passbook.passbook.constant.Constants;
import com.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
/**
 * <h1>消费 Kafka 中的 PassTemplate</h1>
 * 从kafka获取数据存入hbase中
 */
@Slf4j
@Component
public class ConsumePassTemplate {
    /** pass 相关的 HBase 服务 */
    private final IHBasePassService passService;
    @Autowired
    public ConsumePassTemplate(IHBasePassService passService) {
        this.passService = passService;
    }
    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})   //用springboot自带的来完成kafka的读
    public void receive(@Payload String passTemplate,      //从kafka接受数据
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Consumer Receive PassTemplate: {}", passTemplate);
        PassTemplate pt;
        try {
            pt = JSON.parseObject(passTemplate, PassTemplate.class);
        } catch (Exception ex) {
            log.error("Parse PassTemplate Error: {}", ex.getMessage());
            return;
        }
        log.info("DropPassTemplateToHBase: {}", passService.dropPassTemplateToHBase(pt));
    }
}
