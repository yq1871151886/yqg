package com.fh.store_product_api.controller;

import com.fh.store_product_api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("menu")
public class MenuController {



    @Autowired
    private MenuService menuService;



    @GetMapping("queryMenu")
    @CrossOrigin(maxAge = 3000,origins = "http://localhost:8080")
    public List<Map<String,Object>> queryMenu(){
        List<Map<String, Object>> maps = menuService.queryMenu();
        return maps;
    }



}
