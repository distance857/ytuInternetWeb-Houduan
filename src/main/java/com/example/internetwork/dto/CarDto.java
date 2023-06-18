package com.example.internetwork.dto;

import com.example.internetwork.entity.Car;
import lombok.Data;

@Data
public class CarDto {
    private String cid;
    private Integer num;
    private String pid;
    private String uid;
    private String item_type;
    private double price;

    public CarDto(Car car) {
        this.cid = car.getCid();
        this.num = car.getNum();
        this.pid = car.getPid();
        this.uid = car.getUid();
    }

    public CarDto() {
    }
}
