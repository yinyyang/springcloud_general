package com.springcloud.resource.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.springcloud.resource.feign")
@Configuration
public class FeignConfig {

}
