package com.fh.controller;

import com.fh.enumbean.LoginCode;
import com.fh.loginAop.LoginAnnotation;
import com.fh.service.CartService;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("cart")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080",exposedHeaders = "NOLOGIN")
public class CartController {

    @Autowired
    private CartService cartService;


    @LoginAnnotation
    @GetMapping("/{shopsid}")
    public LoginCode joinCart(@PathVariable Integer shopsid, HttpServletRequest request){
        String phone = (String) request.getAttribute("phone");

        return cartService.addCart(shopsid,phone);
    }


    @LoginAnnotation
    @GetMapping
    public LoginCode queryCartCount(){
        HttpServletRequest request = UtilsTools.getSession();
        String phone = (String) request.getAttribute("phone");
        LoginCode loginCode = cartService.queryCartShopCount(phone);
        return loginCode;
    }

    @LoginAnnotation
    @GetMapping("queryCart")
    public LoginCode queryCart(){
        HttpServletRequest request = UtilsTools.getSession();
        String phone = (String) request.getAttribute("phone");
        LoginCode loginCode = cartService.queryCart(phone);
        return loginCode;
    }







}
