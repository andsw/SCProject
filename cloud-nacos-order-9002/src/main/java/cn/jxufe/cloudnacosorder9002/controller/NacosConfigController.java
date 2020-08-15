package cn.jxufe.cloudnacosorder9002.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hsw
 * @date 2020/8/15 15:00
 */
@RestController
@RefreshScope
public class NacosConfigController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping(value = "/nacos/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
