package com.springcloud.rcba.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.springcloud.rcba.feign")
@Configuration
public class FeignConfig {

}
