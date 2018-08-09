package com.itmuch.config;

import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class TestConfiguration {
    @Autowired
    IClientConfig config;

    //懒加载模式，只有请求的时候才加载 ribbonRule 。
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}