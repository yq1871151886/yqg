package com.fh.service.impl;

import com.alibaba.fastjson.JSON;
import com.fh.bean.Shops;
import com.fh.bean.po.ShopsPo;
import com.fh.bean.vo.ShopsVo;
import com.fh.dao.ShopDao;
import com.fh.service.ShopService;
import com.fh.utils.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;





    /*增加*/
    public void addShop(Shops shops,String[] electricIds){
        shops.setCreateTime(new Date());
        shopDao.insert(shops);
        for (int i = 0;i<electricIds.length;i++){
            shopDao.addShopidAndElectricid(shops.getId(),electricIds[i]);
        }
    }
    /*修改*/
    public void updateShops(Shops shops,String[] electricIds){
        shopDao.updateById(shops);
        shopDao.deleteShopAndElectricidByshopId(shops.getId());
        for (int i = 0;i<electricIds.length;i++){
            shopDao.addShopidAndElectricid(shops.getId(),electricIds[i]);
        }
    }
    /*删除*/
    public void deleteShops(Integer id){
        shopDao.deleteById(id);
        shopDao.deleteShopAndElectricidByshopId(id);
    }


    public String queryShopsPage(ShopsPo shops){
        Integer start = shops.getLimit()* (shops.getPage()-1);
        Long aLong = shopDao.queryShopsCount(shops);

        List<ShopsVo> shopsVos = shopDao.queryShopsPage(start, shops);
        Layui data = Layui.data(aLong, shopsVos);
        String s = JSON.toJSONString(data);
        return s;
    }

    public Shops queryShopsById(Integer id){
        return shopDao.selectById(id);
    }


    public List<Map<String,Object>> queryBrand(){
        List<Map<String, Object>> maps = shopDao.queryBrand();
        return maps;
    }

}
