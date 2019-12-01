package com.fh.controller;


import com.fh.bean.Brand;
import com.fh.bean.po.BrandPo;
import com.fh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("brand")
public class BrandController {
        @Autowired
        private BrandService brandService;

    @RequestMapping("toAddOrUpdateBrand")
    public ModelAndView toAddOrUpdateBrand(String id){
        ModelAndView mav = new ModelAndView("view/brand/brandAddOrUpdate");
        if (id!=null){
            Brand brand = brandService.queryById(id);
            mav.addObject("brand",brand);
        }else {
            mav.addObject("brand",new Brand());
        }
        return mav;
    }

    @RequestMapping("addBrand")
    @ResponseBody
    public Map<String,Object> addBrand(Brand brand,@RequestParam(value = "electricIds",required = false) String[] electricIds){
        Map<String,Object> map = null;
        if (brand.getId()!=null && brand.getId()!=""){
            brandService.updateBrandById(brand,electricIds);
            map= new HashMap<String, Object>();
            map.put("message","修改成功");
        }else {
            brandService.addBrand(brand,electricIds);
            map= new HashMap<String, Object>();
            map.put("message","新增成功");
        }


        return map;
    }


    @RequestMapping("queryBrandPage")
    @ResponseBody
    public String queryBrandPage(BrandPo brandPo){
        String s = brandService.queryBrandPage(brandPo);
        return s;
    }

    @RequestMapping("deleteBrand")
    @ResponseBody
    public Map<String,Object> deleteBrand(String id){
        brandService.deleteBrandById(id);
        Map<String,Object> map= new HashMap<String, Object>();
        map.put("message","删除成功");
        return map;
    }


}
