package com.itmuch.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
    //  @Autowired
    //  IClientConfig config;

    //预加载模式，只要容器启动就加载 ribbonRule 。
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}