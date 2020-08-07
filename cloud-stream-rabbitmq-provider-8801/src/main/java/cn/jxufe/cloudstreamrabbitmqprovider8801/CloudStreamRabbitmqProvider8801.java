package cn.jxufe.cloudstreamrabbitmqprovider8801;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hsw
 * @date 2020/8/6 22:08
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitmqProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqProvider8801.class, args);
    }
}
