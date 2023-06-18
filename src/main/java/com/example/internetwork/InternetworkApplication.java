package com.example.internetwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.internetwork.mapper")
public class InternetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternetworkApplication.class, args);
    }

}
