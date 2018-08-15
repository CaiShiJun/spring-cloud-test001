package com.battcn.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BattcnCloudDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattcnCloudDiscoveryApplication.class, args);
	}
}
