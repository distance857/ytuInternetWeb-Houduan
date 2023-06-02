package com.example.internetwork.bean;

import lombok.Data;

@Data
public class Car {
    private String cid;
    private Integer num;
    private String pid;
    private String uid;
    private Integer price;

    public Car() {
    }

    public Car(String cid, Integer num, String pid, String uid) {
        this.cid = cid;
        this.num = num;
        this.pid = pid;
        this.uid = uid;
    }
}
