package com.fh.store_product_api.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.store_product_api.bean.User;
import com.fh.store_product_api.bean.po.UserPo;
import com.fh.store_product_api.bean.vo.UserVo;
import com.fh.store_product_api.dao.UserDao;
import com.fh.store_product_api.service.UserService;
import com.fh.store_product_api.utils.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    public User queryUserByName(String loginName){
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("loginName",loginName);
        User user = userDao.selectOne(wrapper);
        return user;
    }
    public void addUser(User user){
        userDao.insert(user);
    }


    public String queryUserPage(UserPo user){
        Integer start =user.getLimit()*(user.getPage()-1);
        Long aLong = userDao.queryUserCount(user);
        List<UserVo> userVos = userDao.queryUserPage(start, user);

        Layui data = Layui.data(aLong, userVos);

        return JSON.toJSONString(data);
    }

    public User queryById(String id){
        User user = userDao.selectById(id);
        return user;
    }


    public List<User> queryUserByPhone(String phoneNum){
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("phone",phoneNum);
        List<User> users = userDao.selectList(wrapper);
        return users;

    }




}
