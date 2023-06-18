package com.example.internetwork.service;

import com.example.internetwork.entity.Car;
import com.example.internetwork.dto.CarDto;

import java.util.ArrayList;

public interface CarService {

    ArrayList<CarDto> getCars(Integer uid);

    Boolean deleteCar(String id);


    Boolean createCar(Car car);
}
