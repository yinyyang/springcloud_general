package com.springcloud.zuul.config;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.springcloud.zuul.feign")
@Configuration
public class FeignConfig {

}
