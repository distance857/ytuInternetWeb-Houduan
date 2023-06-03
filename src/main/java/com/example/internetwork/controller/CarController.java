package com.example.internetwork.controller;

import com.example.internetwork.bean.Car;
import com.example.internetwork.dto.CarDto;
import com.example.internetwork.service.CarService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "*",maxAge = 3600)   //允许跨域访问
public class CarController {

    @Resource
    private CarService carService;

    @GetMapping("/getCars")
    public ArrayList<CarDto> getCars(@RequestParam("uid") Integer uid) { return carService.getCars(uid);}

    @DeleteMapping("/deleteCar")
    public Boolean deleteCar(@RequestBody CarDto carDto) {
        return carService.deleteCar(carDto.getCid());
    }

    @DeleteMapping("/deleteCars")
    public void deleteCars(@RequestBody ArrayList<CarDto> carDtos) {
        for (CarDto carDto: carDtos) {
            carService.deleteCar(carDto.getCid());
        }
    }

    @PostMapping("/createCar")
    public Boolean createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

}
