package cn.jxufe.cloudconsumerfeignhystrix83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hsw
 * @date 2020/7/26 21:32
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class CloudConsumerFeignHystrix83 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignHystrix83.class, args);
    }
}
