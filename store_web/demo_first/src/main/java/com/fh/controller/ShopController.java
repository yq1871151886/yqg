package com.fh.controller;

import com.fh.bean.Shops;
import com.fh.bean.po.ShopsPo;
import com.fh.service.ShopService;
import com.fh.utils.CopyFile;
import com.fh.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    /*
    * 去增加或者修改页面
    * */
    @RequestMapping("toAddShop")
    public ModelAndView toAddShop(Integer id){
        ModelAndView mav = new ModelAndView("view/shop/addShops");
        List<Map<String, Object>> maps = shopService.queryBrand();
        mav.addObject("brand",maps);
        if (id!=null){
            Shops shops = shopService.queryShopsById(id);
            mav.addObject("shops",shops);
        }else {
            Shops shops =new Shops();
            mav.addObject("shops",shops);
        }
        return mav;
    }


    /*
    * 增加与修改
    * */
    @RequestMapping("addShops")
    @ResponseBody
    public Map<String,Object> addShop(Shops shops,@RequestParam(value = "electricIds",required = false) String[] electricIds){
        Map<String,Object> map=new HashMap<String, Object>();
        if (shops.getId()==null){
            shopService.addShop(shops,electricIds);
            map.put("message","增加成功");
        }else {
            shopService.updateShops(shops,electricIds);
            map.put("message","修改成功");
        }
        return map;
    }

    @RequestMapping("queryShopPage")
    @ResponseBody
    public String queryShopPage(ShopsPo shops){
        String s = shopService.queryShopsPage(shops);
        return s;
    }


    @RequestMapping("deleteShopsById")
    @ResponseBody
    public Map<String,Object> deleteShopsById(Integer id){
        shopService.deleteShops(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","删除成功");
        return map;
    }
    @RequestMapping(value = "uploadImage")
    @ResponseBody
    public Map<String,Object> uploadImage(@RequestParam("fileImage") MultipartFile fileImage) throws Exception {
        OSSClientUtil ossClientUtil = new OSSClientUtil();
        String s = ossClientUtil.uploadImg2Oss(fileImage);
        String imageUrl = ossClientUtil.getImageUrl(s);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("url",imageUrl);
        return map;
    }




}
