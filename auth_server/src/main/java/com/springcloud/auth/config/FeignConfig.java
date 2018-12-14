package com.springcloud.auth.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.springcloud.auth.feign")
@Configuration
public class FeignConfig {

}
