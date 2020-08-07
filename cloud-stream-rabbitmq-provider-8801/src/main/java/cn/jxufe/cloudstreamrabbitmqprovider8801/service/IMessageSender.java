package cn.jxufe.cloudstreamrabbitmqprovider8801.service;

/**
 * @author hsw
 * @date 2020/8/6 22:09
 */
public interface IMessageSender {
    /**
     * 发送消息
     * @return
     */
    String send(String content);
}
