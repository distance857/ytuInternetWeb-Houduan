package com.example.ytuinternetwebhouduan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.example.ytuinternetwebhouduan.mapper")

public class YtuInternetWebHouduanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YtuInternetWebHouduanApplication.class, args);
    }

}
