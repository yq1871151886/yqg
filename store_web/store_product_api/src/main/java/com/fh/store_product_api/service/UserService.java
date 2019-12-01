package com.fh.store_product_api.service;

import com.fh.store_product_api.bean.User;
import com.fh.store_product_api.bean.po.UserPo;

import java.util.List;

public interface UserService {
    User queryUserByName(String loginName);
    void addUser(User user);
    String queryUserPage(UserPo user);
    User queryById(String id);
    List<User> queryUserByPhone(String phoneNum);
}
