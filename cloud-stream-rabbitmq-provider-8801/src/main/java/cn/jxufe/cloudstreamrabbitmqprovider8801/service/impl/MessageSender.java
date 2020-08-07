package cn.jxufe.cloudstreamrabbitmqprovider8801.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

import javax.annotation.Resource;

import cn.jxufe.cloudstreamrabbitmqprovider8801.service.IMessageSender;

/**
 * 可以把Source.class理解成stream提供的推送消息的管道，对应的消费者名为sink！
 * @author hsw
 * @date 2020/8/6 22:11
 */
@EnableBinding(Source.class)
public class MessageSender implements IMessageSender {

    /**
     * stream的另一个组件，表示中间件
     */
    @Qualifier("output")
    @Resource
    private MessageChannel messageChannel;

    @Override
    public String send(String content) {
        String serial = UUID.randomUUID().toString();
        String generatedStr = serial + content;
        messageChannel.send(MessageBuilder.withPayload(generatedStr.getBytes()).build());
        System.out.println("----serial : " + serial);
        return generatedStr;
    }
}
