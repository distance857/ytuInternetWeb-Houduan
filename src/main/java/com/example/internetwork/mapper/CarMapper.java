package com.example.internetwork.mapper;

import com.example.internetwork.bean.Car;
import com.example.internetwork.dto.CarDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CarMapper {

    @Select("SELECT * FROM t_cart JOIN t_product ON t_cart.pid = t_product.id where uid = #{uid}")
    ArrayList<CarDto> getCars(Integer uid);

    @Delete("DELETE from t_cart where cid = #{id}")
    Boolean deleteCar(String id);

    @Insert("insert into t_cart(uid,pid,price,num) values(#{uid},#{pid},#{price},1)")
    Boolean createCar(Car car);
}
