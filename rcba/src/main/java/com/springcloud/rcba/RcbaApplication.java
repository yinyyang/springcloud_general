package com.springcloud.rcba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloud.rcba.mapper")
public class RcbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RcbaApplication.class, args);
    }
}
