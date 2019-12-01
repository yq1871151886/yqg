package com.fh.controller;


import com.fh.bean.Electric;
import com.fh.service.ElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("electric")
public class ElectricController {

    @Autowired
    private ElectricService electricService;



    @RequestMapping("queryElectric")
    @ResponseBody
    public List<Map<String,Object>> queryElectric(){
        List<Map<String, Object>> list = electricService.queryElectric();
        return list;
    }
    /*去查询或修改页面*/
    @RequestMapping("toElectricAddOrUpdate")
    public ModelAndView toElectricAddOrUpdate(String name, String pid, String id){
        ModelAndView mav = new ModelAndView("view/electric/addElectric");
        if (id==null){
            mav.addObject("ele",new Electric());
            mav.addObject("pid",pid);
        }else {
            Electric electric = electricService.queryElectricById(id);
            mav.addObject("ele",electric);
        }
        mav.addObject("parentName",name);

        return mav;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    public Map<String,Object> addOrUpdate(Electric ele){
        Map<String,Object> map = new HashMap<String, Object>();
            if (ele.getId()==null || ele.getId()==""){
                electricService.addElectric(ele);
                map.put("id",ele.getId());
                map.put("pid",ele.getPid());
                map.put("name",ele.getName());
                map.put("message","增加成功");
            }else {
                electricService.updateElectric(ele);
                map.put("name",ele.getName());
                map.put("message","修改成功");
            }
        return map;
    }


}
