package com.fh.store_product_api.dao;

import com.fh.store_product_api.bean.vo.MenuVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
@CacheNamespace(size = 1024)
public interface MenuDao {

    List<MenuVo> queryMunu();




}
