package com.fh.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.User;
import com.fh.bean.po.UserPo;
import com.fh.bean.vo.UserVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {


}
