package com.fh.service.impl;



import com.alibaba.fastjson.JSON;
import com.fh.bean.Brand;
import com.fh.bean.po.BrandPo;
import com.fh.bean.vo.BrandVo;
import com.fh.dao.BrandDao;
import com.fh.service.BrandService;
import com.fh.utils.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    public void addBrand(Brand brand,String[] electricIds){
        brandDao.insert(brand);
        for (int i=0;i<electricIds.length;i++){
            brandDao.addelectricAndBrand(brand.getId(),electricIds[i]);
        }
    }


    public String queryBrandPage(BrandPo brandPo){
        Integer start = brandPo.getLimit() * (brandPo.getPage() - 1);
        Long aLong = brandDao.queryBrandCount(brandPo);
        List<BrandVo> brandVos = brandDao.queryBrandPage(start, brandPo);
        Layui data = Layui.data(aLong, brandVos);
        return JSON.toJSONString(data);
    }

    public Brand queryById(String id){
        Brand brand = brandDao.selectById(id);
        return brand;
    }
    public void updateBrandById(Brand brand,String[] electricIds){
        brandDao.updateById(brand);
        brandDao.deleteElectricidAndBrandByBrandid(brand.getId());
        for (int i=0;i<electricIds.length;i++){
            brandDao.addelectricAndBrand(brand.getId(),electricIds[i]);
        }
    }

    public void deleteBrandById(String id){
        brandDao.deleteById(id);
        brandDao.deleteElectricidAndBrandByBrandid(id);
    }

}
