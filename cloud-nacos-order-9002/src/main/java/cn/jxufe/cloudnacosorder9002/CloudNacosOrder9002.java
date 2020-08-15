package cn.jxufe.cloudnacosorder9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hsw
 * @date 2020/8/15 11:17
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CloudNacosOrder9002 {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(CloudNacosOrder9002.class, args);
        String configInfo = applicationContext.getEnvironment().getProperty("config.info");
        System.out.println("config info is : " + configInfo);
    }
}
