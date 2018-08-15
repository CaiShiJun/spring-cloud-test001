package com.battcn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class H2Application {

    static Logger LOGGER = LoggerFactory.getLogger(H2Application.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("/h2")
    public String home(@RequestParam String email) {
        // 改写法之前有说过是VIP模式
        return restTemplate().getForObject("http://battcn-cloud-h1/h1?email=" + email, String.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }
}
