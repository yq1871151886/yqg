package com.fh.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.User;
import com.fh.bean.po.UserParameter;
import com.fh.bean.vo.UserVo;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
@CacheNamespace(size = 1024)
public interface UserDao extends BaseMapper<User> {

}
