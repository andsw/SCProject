package cn.jxufe.cloueeurekaserver7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author PC
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class CloueEurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloueEurekaServer7002Application.class, args);
    }

}
