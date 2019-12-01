package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Shops;
import com.fh.bean.po.ShopsPo;
import com.fh.bean.vo.ShopsVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
@CacheNamespace(size = 1024)
public interface ShopDao extends BaseMapper<Shops> {

    List<Map<String,Object>> queryBrand();
    Long queryShopsCount(@Param("shops") ShopsPo shops);
    List<ShopsVo> queryShopsPage(@Param("start") Integer start,@Param("shops")ShopsPo shops);
    void addShopidAndElectricid(@Param("shopid") Integer shopid,@Param("electricid") String electricid);
    void deleteShopAndElectricidByshopId(Integer shopid);
}
