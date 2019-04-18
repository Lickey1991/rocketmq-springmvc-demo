package com.lickey.rocketmq.demo.service;

/**
 * @author : lvqi
 * @date : 2019/4/11 16:03
 * @description : TODO
 */

public interface TestService {
    int transactionSend();
    int asyncSend();
    void sendMqMessage(Integer id);
}
