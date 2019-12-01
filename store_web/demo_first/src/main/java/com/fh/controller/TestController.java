package com.fh.controller;

import com.fh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@RequestMapping("test")
@Controller
public class TestController {



    @Autowired
    private TestService testService;



    @RequestMapping("toMain")
    public String toMain(){
        return "view/mainPage.html";
    }

    @RequestMapping("toJsp")
    public String toJsp(String url){
        return url;
    }


}
