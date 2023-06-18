package com.example.internetwork.service;


import com.example.internetwork.dto.CarDto;
import com.example.internetwork.entity.Address;
import com.example.internetwork.entity.CodeData;
import com.example.internetwork.entity.FormData;
import com.example.internetwork.entity.NameData;

import java.util.ArrayList;

public interface AddressService {
    int addAddress(CodeData codedata, FormData formdata, NameData namedata, String userToken);

    ArrayList<Address> getAllAdresss(Integer uid);

    public int deleteAddressByAid(int uid);
}
