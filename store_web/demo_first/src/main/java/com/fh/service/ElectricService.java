package com.fh.service;


import com.fh.bean.Electric;

import java.util.List;
import java.util.Map;

public interface ElectricService {

    List<Map<String,Object>> queryElectric();
    void addElectric(Electric electric);
    void  updateElectric(Electric electric);
    Electric queryElectricById(String id);

}
