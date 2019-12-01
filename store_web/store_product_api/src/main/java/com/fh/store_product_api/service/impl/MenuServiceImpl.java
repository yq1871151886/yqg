package com.fh.store_product_api.service.impl;

import com.fh.store_product_api.bean.vo.ElectricVo;
import com.fh.store_product_api.bean.vo.MenuVo;
import com.fh.store_product_api.dao.MenuDao;
import com.fh.store_product_api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;


    public List<Map<String,Object>> queryMenu(){
        List<MenuVo> menuVos = menuDao.queryMunu();
        return getMenuList("0",menuVos);
    }

    private List<Map<String,Object>> getMenuList(String pid,List<MenuVo> list){
        List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
        list.forEach(menu->{
            Map<String,Object> map=null;
            if (pid.equals(menu.getPid())){
                map = new HashMap<String, Object>();
                map.put("id",menu.getId());
                map.put("pid",menu.getPid());
                map.put("name",menu.getName());
                if (!"0".equals(menu.getImage())){
                    map.put("image",menu.getImage());
                }
                if (!"1".equals(menu.getEle())){
                    map.put("ele",menu.getEle());
                }
                map.put("children",getMenuList(menu.getId(),list));
            }
            if (map!=null){
                lists.add(map);
            }
        });
        return lists;
    }



}
