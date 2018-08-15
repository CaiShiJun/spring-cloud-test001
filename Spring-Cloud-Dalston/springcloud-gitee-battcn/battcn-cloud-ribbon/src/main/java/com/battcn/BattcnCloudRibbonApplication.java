package com.battcn;

import com.config.FooConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RibbonClient(name = "battcn-cloud-hello",configuration = FooConfiguration.class)
public class BattcnCloudRibbonApplication  {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/ribbon")
    public String findHelloByEmail(String email) {
        // VIP模式，不需要填写 IP+端口 Ribbon会去注册中心获取当前可用服务然后做HTTP请求
        return "server  <<==>>  "+restTemplate().getForObject("http://battcn-cloud-hello/hello?email="+email,String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BattcnCloudRibbonApplication.class, args);
    }



}
