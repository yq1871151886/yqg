package com.fh.service.impl;


import com.fh.bean.Electric;
import com.fh.bean.vo.ElectricVo;
import com.fh.dao.ElectricDao;
import com.fh.service.ElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ElectricServiceImpl implements ElectricService {
    @Autowired
    private ElectricDao electricDao;


    @Override
    public List<Map<String, Object>> queryElectric() {
        List<ElectricVo> list = electricDao.queryElectric();
        /*getElectric(0,list)*/
        return getElectric("0",list);
    }


    private List<Map<String,Object>> getElectric(String pid,List<ElectricVo> list){
        List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
        list.forEach(electric->{
            Map<String,Object> map=null;
            if (pid.equals(electric.getPid())){
                map = new HashMap<String, Object>();
                map.put("id",electric.getId());
                map.put("pid",electric.getPid());
                map.put("name",electric.getName());
                map.put("children",getElectric(electric.getId(),list));
            }
            if (map!=null){
                lists.add(map);
            }
        });
        return lists;
    }

    public void addElectric(Electric electric){
        electricDao.insert(electric);
    }
    public void  updateElectric(Electric electric){
        electricDao.updateById(electric);
    }
    public Electric queryElectricById(String id){
        Electric electricPo = electricDao.selectById(id);
        return electricPo;
    }

}
