package cn.jxufe.cloudproviderpayment8005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hsw
 * @date 2020/3/24 15:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8005 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8005.class, args);
    }
}
