package com.springcloud.sfp.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.springcloud.sfp.feign")
@Configuration
public class FeignConfig {

}
