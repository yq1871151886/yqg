package com.fh.service;


import com.fh.bean.User;
import com.fh.bean.po.UserPo;

import java.util.List;

public interface UserService {
    User queryUserByName(String loginName);
    void addUser(User user);
    User queryById(String id);
    User queryUserByPhone(String phoneNum);

    void addUserToKen(String phoneNum,String token);
}
