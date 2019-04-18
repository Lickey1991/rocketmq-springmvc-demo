package com.lickey.rocketmq.demo.controller;

import com.lickey.rocketmq.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lvqi
 * @date : 2019/4/16 17:06
 * @description : TODO
 */
@RestController

public class DemoController {
    @Autowired
    private TestService testService;

    @RequestMapping("/sendMsg")
    public String sendMsg() {
        testService.sendMqMessage(0);
        return "sendMsg ok";
    }

    @RequestMapping("/asyncSend")
    public String asyncSend() {
        testService.asyncSend();
        return "asyncSend ok";
    }

    @RequestMapping("/transactionSend")
    public String transactionSend() {
        testService.transactionSend();
        return "transactionSend ok";
    }

}
