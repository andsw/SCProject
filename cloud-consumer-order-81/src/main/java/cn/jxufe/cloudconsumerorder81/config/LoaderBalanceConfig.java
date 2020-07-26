package cn.jxufe.cloudconsumerorder81.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.jxufe.cloudconsumerorder81.lb.LoaderBalance;
import cn.jxufe.cloudconsumerorder81.lb.MyLoaderBalance;

/**
 * @author hsw
 * @date 2020/7/11 22:01
 * 自定义的loaderBalance的配置类
 */
@Configuration
public class LoaderBalanceConfig {
    @Bean
    public LoaderBalance loaderBalance() {
        return new MyLoaderBalance();
    }
}
