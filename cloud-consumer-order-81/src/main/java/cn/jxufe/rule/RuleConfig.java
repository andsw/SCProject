package cn.jxufe.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hsw
 * @date 2020/4/25 21:33
 */
@Configuration
public class RuleConfig {

    @Bean
    public IRule customRule() {
        return new RandomRule();
    }

}
