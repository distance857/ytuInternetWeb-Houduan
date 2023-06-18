package com.example.internetwork.entity;



import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer gender;//'性别:0-女，1-男',
    String createdTime;
    public User() {
        this.createdTime = String.valueOf(LocalDateTime.now());
    }
//    private String avatar;

    private String token;

}