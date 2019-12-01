package com.fh.controller;


import com.fh.bean.User;
import com.fh.service.UserService;
import com.fh.utils.UtilsTools;
import com.fh.utils.enumbean.LoginCode;
import com.fh.utils.enumbean.LoginEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public LoginCode login(String loginName,String loginPwd){
        if (loginName==null || loginName.trim()=="" || loginPwd==null || loginPwd.trim()==""){
            return LoginCode.error(LoginEnum.NAME_PWD_ERROR);
        }
        User user = userService.queryUserByLoginName(loginName);
        if (user==null){
            return LoginCode.error(LoginEnum.USER_ISNULL);
        }
        if (!loginPwd.equals(user.getLoginPwd())){
            return LoginCode.error(LoginEnum.USER_PWD_ERROR);
        }
        HttpServletRequest request = UtilsTools.getSession();
        if (!new Integer(1).equals(user.getIsValid())){
            return LoginCode.error(LoginEnum.LOGIN_SIVALID);
        }
        request.getSession().setAttribute("user",user);
        return LoginCode.success();
    }





}
