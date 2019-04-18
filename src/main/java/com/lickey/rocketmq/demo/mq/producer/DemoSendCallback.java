package com.lickey.rocketmq.demo.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author : lvqi
 * @date : 2019/4/12 10:05
 * @description : TODO
 */
@Slf4j
@Component
public class DemoSendCallback implements SendCallback {
    @Override
    public void onSuccess(SendResult sendResult) {
        log.info("asyncSend demo mq success!");
    }

    @Override
    public void onException(Throwable throwable) {
        log.error("asyncSend demo mq fail!", throwable);

    }
}
