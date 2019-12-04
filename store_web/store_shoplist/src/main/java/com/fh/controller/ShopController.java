package com.fh.controller;

import com.fh.bean.Shops;
import com.fh.bean.po.ShopsPo;
import com.fh.bean.vo.ShopsVo;
import com.fh.service.ShopService;
import com.fh.utils.OSSClientUtil;
import com.fh.utils.enumbean.LoginCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shop")
public class ShopController {


    @Autowired
    private ShopService shopService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;



    @GetMapping("queryShopsAllByElectricid")
    @CrossOrigin(maxAge = 3000,origins = "http://localhost:8080")
    public List<ShopsVo> queryShopsAllByElectricid(String electricid){
        List<ShopsVo> shopsVos = shopService.queryShopsAllByElectricid(electricid);
        return shopsVos;
    }
    @GetMapping("queryShopsAllByBrandid")
    @CrossOrigin(maxAge = 3000,origins = "http://localhost:8080")
    public List<ShopsVo> queryShopsAllByBrandid(String brandid,String electric){
        List<ShopsVo> shopsVos = shopService.queryShopsByBrandid(brandid,electric);
        return shopsVos;
    }



    @GetMapping("queryShopsByparameter")
    @CrossOrigin(maxAge = 3000,origins ="http://localhost:8080" )
    public String queryShopsByparameter(ShopsPo shops){
        String s = shopService.queryShopsByparameter(shops);
        return s;
    }
    @GetMapping("queryShopsByparameter1")
    @CrossOrigin(maxAge = 3000,origins ="http://localhost:8080" )
    public String queryShopsByparameter1(ShopsPo shops){
        String key =shops.getBrandid()+","+shops.getElectricid()+","+shops.getLimit()+","+shops.getPage() ;
        String s = redisTemplate.boundValueOps(key).get();
        if (StringUtils.isBlank(s)){
            s = shopService.queryShopsByparameter(shops);
            redisTemplate.boundValueOps(key).set(s);
            System.out.println("---------从数据库中获取到的----------");
        }else {
            System.out.println("---------从redis中获取到的----------");
        }
        return s;
    }
    @GetMapping("/queryStockByShopId/{shopId}")
    public Integer queryStockByShopId(@PathVariable Integer shopId){
        Integer stock = shopService.queryStockByShopId(shopId);
        return stock;
    }







}
