package com.lickey.rocketmq.demo.mq.producer;

import com.alibaba.fastjson.JSON;
import com.shandiangou.starter.rocketmq.annotation.MQTransactionProducer;
import com.shandiangou.starter.rocketmq.base.AbstractMQTransactionProducer;
import com.lickey.rocketmq.demo.domain.Test;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * @author : lvqi
 * @date : 2019/4/11 15:15
 * @description : 事物消息 producer
 */
@Component
@MQTransactionProducer(producerGroup = "SELF_TRANS_GROUP")
@Slf4j
public class RocketMqTransactionProducer extends AbstractMQTransactionProducer {


    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        Test test = (Test) arg;
        log.info("executeLocalTransaction ,arg:{}!", JSON.toJSONString(test));

        // executeLocalTransaction
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {

        log.info("checkLocalTransaction , MessageExt:{} !", JSON.toJSONString(msg));
        // LocalTransactionState.ROLLBACK_MESSAGE
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
