package cn.jxufe.cloudstreamrabbitmqlistener8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hsw
 * @date 2020/8/7 23:05
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitmqListener8002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqListener8002.class, args);
    }
}
