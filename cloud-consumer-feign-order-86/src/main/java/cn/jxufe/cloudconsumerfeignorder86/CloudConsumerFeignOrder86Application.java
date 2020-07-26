package cn.jxufe.cloudconsumerfeignorder86;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author PC
 */
@EnableFeignClients
@SpringBootApplication
public class CloudConsumerFeignOrder86Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrder86Application.class, args);
    }

}
