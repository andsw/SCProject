package cn.jxufe.cloudproviderpayment8004;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hsw
 * @date 2020/3/24 14:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "cn.jxufe.cloudproviderpayment8004.dao")
public class CloudProviderPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004.class, args);
    }
}
