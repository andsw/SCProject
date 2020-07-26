package cn.jxufe.cloudconsumerorder85;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hsw
 * @date 2020/3/24 15:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrder85 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder85.class, args);
    }
}
