package com.fh.service;

import com.fh.bean.Shops;
import com.fh.bean.po.ShopsPo;

import java.util.List;
import java.util.Map;

public interface ShopService {

    void addShop(Shops shops,String[] electricIds);
    String queryShopsPage(ShopsPo shops);
    Shops queryShopsById(Integer id);
    void updateShops(Shops shops,String[] electricIds);
    void deleteShops(Integer id);
    List<Map<String,Object>> queryBrand();
}
