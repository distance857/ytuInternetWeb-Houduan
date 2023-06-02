package com.example.internetwork.service.impl;

import com.example.internetwork.bean.Car;
import com.example.internetwork.dto.CarDto;
import com.example.internetwork.mapper.CarMapper;
import com.example.internetwork.service.CarService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;

    @Override
    public ArrayList<CarDto> getCars() {
        return carMapper.getCars();
    }

    @Override
    public Boolean deleteCar(String id) {
        return carMapper.deleteCar(id);
    }

    @Override
    public Boolean createCar(Car car) {
        return carMapper.createCar(car);
    }


}
