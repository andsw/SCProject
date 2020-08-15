package cn.jxufe.cloudnacospayment9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hsw
 * @date 2020/8/15 9:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosPayment9001.class, args);
    }
}
