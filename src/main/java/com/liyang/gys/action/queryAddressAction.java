package com.liyang.gys.action;

import com.liyang.gys.entity.City;
import com.liyang.gys.entity.Province;
import com.liyang.gys.service.AddressService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/24 20:34
 */


public class queryAddressAction {
    private String provinceName;

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    private Map<String,Object> map;

    public Map<String,Object> getMap() {
        return map;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String queryProvince(){
        AddressService as = new AddressService();
        List<Province> list = as.queryProvince();
        map = new HashMap<String, Object>();
        map.put("province",list);
        return "success";
    }

    public String queryCity(){
        AddressService as = new AddressService();
        List<City> list = as.queryCity(provinceName);
        map = new HashMap<String, Object>();
        map.put("city",list);
        return "success";
    }

}
