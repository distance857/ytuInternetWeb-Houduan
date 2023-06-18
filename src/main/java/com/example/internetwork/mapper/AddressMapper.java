package com.example.internetwork.mapper;


import com.example.internetwork.dto.CarDto;
import com.example.internetwork.entity.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AddressMapper {

    List<Address> getDefaultAddress(@Param("uid") Integer uid);

    int insertAddress(@Param("address") Address address);

    @Select(" select *\n" +
            "        from t_address\n" +
            "        where uid = #{uid}")
    ArrayList<Address> getAllAdresss(Integer uid);

    @Delete("DELETE FROM t_address WHERE aid = #{aid}")
    int deleteAddressByAid(int aid);
}
