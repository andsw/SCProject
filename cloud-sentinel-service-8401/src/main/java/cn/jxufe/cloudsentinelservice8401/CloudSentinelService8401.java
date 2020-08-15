package cn.jxufe.cloudsentinelservice8401;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hsw
 * @date 2020/8/15 21:39
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CloudSentinelService8401 {
    public static void main(String[] args) {
        SpringApplication.run(CloudSentinelService8401.class, args);
    }
}
