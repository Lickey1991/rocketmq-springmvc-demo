package com.lickey.rocketmq.demo.mq.producer;

import com.alibaba.fastjson.JSON;
import com.lickey.starter.rocketmq.annotation.MQProducer;
import com.lickey.starter.rocketmq.base.AbstractMQProducer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : lvqi
 * @date : 2019/4/11 15:11
 * @description : TODO
 */
@Component
@MQProducer(producerGroup = "SELF_TEST_GROUP")
@Slf4j
public class RocketMqProducer extends AbstractMQProducer {

    @Getter
    @Value("MQ_TEST_DEMO")
    private String demoTopic;
    @Override
    public void doAfterSyncSend(Message message, SendResult sendResult) {
        log.info("message send success , message:{}, result:{}", JSON.toJSONString(message), JSON.toJSONString(sendResult));
    }

}
