package com.springcloud.sfp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloud.sfp.mapper")
public class SFPApplication {

    public static void main(String[] args) {
        SpringApplication.run(SFPApplication.class, args);
    }
}
