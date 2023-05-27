package com.example.ytuinternetwebhouduan.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    int uid;
    String username;
    String password;
    String phone;
    String email;
    String gender;
    String createdTime;

    public User() {
        this.createdTime = String.valueOf(LocalDateTime.now());
    }
}
