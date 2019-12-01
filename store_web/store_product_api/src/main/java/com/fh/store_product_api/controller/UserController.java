package com.fh.store_product_api.controller;

import com.fh.store_product_api.bean.User;
import com.fh.store_product_api.service.UserService;
import com.fh.store_product_api.utils.SendCode;
import com.fh.store_product_api.utils.UtilsTools;
import com.fh.store_product_api.utils.enumbean.LoginCode;
import com.fh.store_product_api.utils.enumbean.LoginEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
        @Autowired
        private UserService userService;

    @GetMapping
    @CrossOrigin(maxAge = 3000,origins = "http://localhost:8080")
    public LoginCode phoneCode(String phoneNum) throws IOException {
        List<User> users = userService.queryUserByPhone(phoneNum);
        if (users.size()<1){
            return LoginCode.error(LoginEnum.LOGIN_PHONE_NULL);
        }
        HttpSession session = UtilsTools.getSession().getSession();
        String s = SendCode.sendCode(phoneNum);

        session.setAttribute("phoneCode",s);
        return LoginCode.success(LoginEnum.LOGIN_SENDCODE_SUCCESS);
    }

    @PostMapping
    @CrossOrigin(maxAge = 3000,origins = "http://localhost:8080")
    public LoginCode phoneLogin(String phoneNum,String code) throws IOException {
        boolean b = SendCode.verifyCode(phoneNum, code);
        if (!b){
            return LoginCode.error(LoginEnum.LOGIN_PHONECODE_ERROR);
        }else {
            return LoginCode.success();
        }

    }








}
