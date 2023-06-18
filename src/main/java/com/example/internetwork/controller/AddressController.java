package com.example.internetwork.controller;

import com.example.internetwork.dto.CarDto;
import com.example.internetwork.entity.Address;
import com.example.internetwork.request.AddressRequest;
import com.example.internetwork.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("*")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }



    @PostMapping("/address/add")
    public ResponseEntity<Map<String,Object>> addAddress(@RequestBody AddressRequest addressRequest) {

        int result=addressService.addAddress(
                addressRequest.getCodedata(),
                addressRequest.getFormdata(),
                addressRequest.getNamedata(),
                addressRequest.getUsertoken());

        Map<String, Object> response = new HashMap<>();
        if (result == 1) {
            response.put("success", true);
            response.put("message", "恭喜您！新增地址成功！");
            return ResponseEntity.ok().body(response);
        } else {
            response.put("success", false);
            response.put("message", "增加失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/address")
    public ArrayList<Address> getCars(@RequestParam("uid") Integer uid) { return addressService.getAllAdresss(uid);}

    @DeleteMapping("/address/{aid}")
    public ResponseEntity<Void> deleteUser(@PathVariable int aid) {
        addressService.deleteAddressByAid(aid);
        return ResponseEntity.noContent().build();
    }
}