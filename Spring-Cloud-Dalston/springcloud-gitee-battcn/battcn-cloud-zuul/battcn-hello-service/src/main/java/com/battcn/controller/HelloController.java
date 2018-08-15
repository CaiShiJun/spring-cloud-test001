package com.battcn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Levin
 * @date 2017-08-14.
 */
@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String applicationName;

}
