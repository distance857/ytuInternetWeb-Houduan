package com.example.internetwork.service.impl;


import com.example.internetwork.entity.Address;
import com.example.internetwork.entity.CodeData;
import com.example.internetwork.entity.FormData;
import com.example.internetwork.entity.NameData;
import com.example.internetwork.mapper.AddressMapper;
import com.example.internetwork.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public int addAddress(CodeData codedata, FormData formdata, NameData namedata, String userToken) {
        /*Integer areaCode = codedata.getAreaCode();
        Integer cityCode = codedata.getCityCode();
        Integer provinceCode = codedata.getProvinceCode();*/
        String provinceCode = codedata.getProvince().toString();
        String cityCode = codedata.getCity().toString();
        String areaCode = codedata.getArea().toString();
        String address = formdata.getAddress();
        String name = formdata.getName();
        String phone = formdata.getPhone();
        String area = namedata.getArea();
        String city = namedata.getCity();
        String province = namedata.getProvince();
        /**
         * userToken里面还有uid，需要以后解析，现在没有
         */
        Integer uid = 1001;
        List<Address> AddressList = addressMapper.getDefaultAddress(uid);

//        System.out.println(AddressList);
//        Integer isDefault = AddressList == null ? 1 : 0;
        Integer isDefault=0;
        if (AddressList.isEmpty()) {
            isDefault=1;
        }
        String createTime = LocalDateTime.now().toString();

        Address address1 = new Address(uid, name, province, provinceCode, city, cityCode, area, areaCode, address, phone, isDefault, createTime);
        System.out.println(address1);
       return addressMapper.insertAddress(address1);


    }

    @Override
    public ArrayList<Address> getAllAdresss(Integer uid) {
        return addressMapper.getAllAdresss(uid);
    }

    @Override
    public int deleteAddressByAid(int aid) {
        return addressMapper.deleteAddressByAid(aid);
    }
}
