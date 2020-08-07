package cn.jxufe.cloudstreamrabbitmqprovider8801.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import cn.jxufe.cloudstreamrabbitmqprovider8801.service.IMessageSender;

/**
 * @author hsw
 * @date 2020/8/6 22:17
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageSender messageSender;

    @GetMapping(value = "/send/{content}")
    public String sendMessage(@PathVariable String content) {
        return messageSender.send(content);
    }
}
