package cn.jxufe.cloudproviderhystrix8003;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * -@SpringCloudApplication = @SpringBootApplication + @EnableFeignClient + @EnableCircuitBreaker !
 * @author hsw
 * @date 2020/7/26 19:19
 */
@SpringCloudApplication
public class CloudProviderHystrix8003Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrix8003Application.class, args);
    }
}
