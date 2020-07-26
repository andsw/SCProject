package cn.jxufe.cloudconsumerorder84;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hsw
 * @date 2020/3/24 15:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrder84 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder84.class, args);
    }
}
