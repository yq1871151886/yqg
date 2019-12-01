package com.fh.store_product_api.service;



import com.fh.store_product_api.bean.Electric;

import java.util.List;
import java.util.Map;

public interface ElectricService {

    List<Map<String,Object>> queryElectric();
    void addElectric(Electric electric);
    void  updateElectric(Electric electric);
    Electric queryElectricById(Integer id);

}
