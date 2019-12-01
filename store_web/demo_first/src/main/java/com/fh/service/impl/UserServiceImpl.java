package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.bean.User;
import com.fh.dao.UserDao;
import com.fh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByLoginName(String loginName) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("loginName",loginName);
        User user = userDao.selectOne(wrapper);
        return user;
    }



}
