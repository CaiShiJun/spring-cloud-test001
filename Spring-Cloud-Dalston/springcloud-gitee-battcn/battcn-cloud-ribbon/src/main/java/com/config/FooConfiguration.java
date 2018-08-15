package com.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Levin
 * @date 2017-07-26.
 */
@Configuration

public class FooConfiguration {

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig) {
        return new RandomRule();
    }
}