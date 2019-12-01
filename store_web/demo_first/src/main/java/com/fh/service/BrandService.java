package com.fh.service;

import com.fh.bean.Brand;
import com.fh.bean.po.BrandPo;

public interface BrandService {

    void addBrand(Brand brand,String[] electricIds);
    String queryBrandPage(BrandPo brandPo);
    Brand queryById(String id);
    void updateBrandById(Brand brand,String[] electricIds);
    void deleteBrandById(String id);
}
