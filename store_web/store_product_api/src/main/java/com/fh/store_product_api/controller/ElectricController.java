package com.fh.store_product_api.controller;


import com.fh.store_product_api.bean.Electric;
import com.fh.store_product_api.service.ElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("electric")
public class ElectricController {

    @Autowired
    private ElectricService electricService;

    @GetMapping("queryElectric")
    @CrossOrigin(maxAge = 3000,origins = "http://localhost:8080")
    public List<Map<String,Object>> queryElectric(){
        List<Map<String, Object>> list = electricService.queryElectric();



        return list;
    }




}
