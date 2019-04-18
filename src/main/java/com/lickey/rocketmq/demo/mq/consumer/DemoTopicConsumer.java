package com.lickey.rocketmq.demo.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.lickey.starter.rocketmq.annotation.MQConsumer;
import com.lickey.starter.rocketmq.base.AbstractMQPushConsumer;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author : lvqi
 * @date : 2019/4/11 15:50
 * @description : 消费
 */
@MQConsumer(topic = "MQ_TEST_DEMO", consumerGroup = "SELF_TEST_C_GROUP")
@Slf4j
public class DemoTopicConsumer  extends AbstractMQPushConsumer {
    /**
     * 返回 false，会重试
     * @param message
     * @param extMap
     * @return
     */
    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        log.info("DemoTopicConsumer process message: " + JSON.toJSONString(message));
        log.info("DemoTopicConsumer process message.properties: " + JSON.toJSONString(extMap));
        return true;
    }
}
