package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class Turbine2Application {
    public static void main(String[] args) {
        SpringApplication.run(Turbine2Application.class, args);
    }
}
