package com.example.internetwork.mapper;

import com.example.internetwork.dto.CarDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CarMapper {

    @Select("SELECT * FROM t_cart JOIN t_product ON t_cart.pid = t_product.id")
    ArrayList<CarDto> getCars();

    @Delete("DELETE from t_cart where cid = #{id}")
    Boolean deleteCar(String id);



}
