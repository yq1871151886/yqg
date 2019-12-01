package com.fh.store_product_api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.store_product_api.bean.User;
import com.fh.store_product_api.bean.po.UserPo;
import com.fh.store_product_api.bean.vo.UserVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
@CacheNamespace(size = 1024)
public interface UserDao extends BaseMapper<User> {

    Long queryUserCount(@Param("user") UserPo user);

    List<UserVo> queryUserPage(@Param("start") Integer start, @Param("user") UserPo user);

}
