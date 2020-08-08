package cn.jxufe.cloudstreamrabbitmqlistener8803;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hsw
 * @date 2020/8/8 10:02
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitmqListener8803 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqListener8803.class, args);
    }
}
