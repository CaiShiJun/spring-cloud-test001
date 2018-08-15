package com.battcn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloApplication {
    static Logger LOGGER = LoggerFactory.getLogger(HelloApplication.class);
    @GetMapping("/h1")
    public void home() {
        for (int i = 1;i < 6;i++) {
            try {
                Thread.sleep(i * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info("[当前进度] - [{}]",i);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
