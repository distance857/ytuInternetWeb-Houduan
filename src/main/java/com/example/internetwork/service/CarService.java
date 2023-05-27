package com.example.internetwork.service;

import com.example.internetwork.dto.CarDto;

import java.util.ArrayList;

public interface CarService {

    ArrayList<CarDto> getCars();

    Boolean deleteCar(String id);


}
