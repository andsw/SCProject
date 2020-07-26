package cn.jxufe.cloudconsumerorder81;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author PC
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = RuleConfig.class)
public class CloudConsumerOrder81Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder81Application.class, args);
    }

}
