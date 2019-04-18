package com.lickey.rocketmq.demo.service.impl;


import com.lickey.starter.rocketmq.base.MessageBuilder;
import com.lickey.rocketmq.demo.domain.Test;
import com.lickey.rocketmq.demo.mq.producer.DemoSendCallback;
import com.lickey.rocketmq.demo.mq.producer.RocketMqProducer;
import com.lickey.rocketmq.demo.mq.producer.RocketMqTransactionProducer;
import com.lickey.rocketmq.demo.mq.producer.TestProducer;
import com.lickey.rocketmq.demo.service.TestService;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : lvqi
 * @date : 2019/4/11 16:03
 * @description : TODO
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private RocketMqProducer rocketMqProducer;
    @Autowired
    private TestProducer testProducer;
    @Autowired
    private RocketMqTransactionProducer rocketMqTransactionProducer;
    @Autowired
    private DemoSendCallback demoSendCallback;

    @Override
    public int transactionSend() {
        Test test = new Test();
        test.setId(234);
        test.setName("transactionSend");
        test.setStatus(4);
        //构建message
        MessageBuilder messageBuilder = MessageBuilder.of("MQ_TEST_DEMO", "transactionSendTag");
        messageBuilder.setMessageBody(test);
        messageBuilder.setKey("mvcDemo_transactionSend");
        rocketMqTransactionProducer.sendMessageInTransaction(messageBuilder.build(), test);
        return 0;
    }

    @Override
    public int asyncSend() {
        Test test = new Test();
        test.setId(1);
        test.setName("asyncSend");
        test.setStatus(3);
        //构建message
        MessageBuilder messageBuilder = MessageBuilder.of(rocketMqProducer.getDemoTopic(), "asyncSendTag");
        messageBuilder.setMessageBody(test);
        messageBuilder.setKey("mvcDemo_asyncSend");
        rocketMqProducer.asyncSend(messageBuilder.build(), demoSendCallback);
        return 0;
    }

    @Override
    public void sendMqMessage(Integer id) {
        Test test = new Test();
        test.setId(1);
        test.setName("sendMqMessqge");
        test.setStatus(3);
        //构建message
        MessageBuilder messageBuilder2 = MessageBuilder.of(rocketMqProducer.getDemoTopic(), "syncSendTag");
        messageBuilder2.setMessageBody(test);
        messageBuilder2.setKey("mvcDemo_sendMqMessage");
        Message message = messageBuilder2.build();
        rocketMqProducer.syncSend(messageBuilder2.build());

    }
}
