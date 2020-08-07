package cn.jxufe.cloudstreamrabbitmqprovider8801.service.impl;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author hsw
 * @date 2020/8/6 22:43
 */
public interface Source {
    String OUTPUT = "output";
    /**
     * 这里的output对应的就是application.yml中配置的binder中的output！
     * @return
     */
    @Output(Source.OUTPUT)
    MessageChannel output();
}
