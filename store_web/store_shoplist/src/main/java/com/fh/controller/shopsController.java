package com.fh.controller;

import com.fh.bean.Shops;
import com.fh.service.ShopService;
import com.fh.utils.enumbean.LoginCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shops")
public class shopsController {

    @Autowired
    private ShopService shopService;



    @GetMapping("/{shopsId}")
    public LoginCode queryById(@PathVariable Integer shopsId){
        Shops shops = shopService.queryShopsById(shopsId);
        return LoginCode.success(shops);
    }

}
