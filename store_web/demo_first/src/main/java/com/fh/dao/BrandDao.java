package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Brand;
import com.fh.bean.po.BrandPo;
import com.fh.bean.vo.BrandVo;
import lombok.Data;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
@CacheNamespace(size = 1024)
public interface BrandDao extends BaseMapper<Brand> {

    Long queryBrandCount(@Param("brand") BrandPo brand);

    List<BrandVo> queryBrandPage(@Param("start") Integer start, @Param("brand") BrandPo brand);
    void addelectricAndBrand(@Param("brandid") String brandid,@Param("electricid") String electricid);
    void deleteElectricidAndBrandByBrandid(String brandid);
}
