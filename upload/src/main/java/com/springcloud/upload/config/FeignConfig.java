package com.springcloud.upload.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.springcloud.upload.feign")
@Configuration
public class FeignConfig {

}
