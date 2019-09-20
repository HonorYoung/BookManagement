package com.liyang.gys.action;

import com.liyang.commons.Page;
import com.liyang.gys.entity.City;
import com.liyang.gys.entity.Gys;
import com.liyang.gys.entity.Province;
import com.liyang.gys.service.GysService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/29 9:01
 */
public class GysAction {
    private String name;
    private String address;
    private String province;
    private String city;
    private String street;

    public String getProvinceName() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Gys sup;

    public Gys getSup() {
        return sup;
    }

    public void setSup(Gys sup) {
        this.sup = sup;
    }

    private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String addSupplier(){
        GysService gs = new GysService();
        Gys gys = new Gys();
        gys.setAddress(province+city+street);
        gys.setLxr(sup.getLxr());
        gys.setName(sup.getName());
        gys.setPhone(sup.getPhone());
        gs.addSupplier(gys);
        return "success";
    }

    private int pageSize;
    private int pageNumber;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    private Page<Gys> page;

    public Page<Gys> getPage() {
        return page;
    }

    public void setPage(Page<Gys> page) {
        this.page = page;
    }

    public String querySomeSupplier(){
        GysService gs = new GysService();
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("address",address);
        page = new Page<>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        page.setTotal(gs.queryCount(map));
        page.setRows(gs.querySomeSupplier(map,page.getStart(),pageSize));
        return "querySuccess";
    }

    public String querySupplier(){
        GysService gs = new GysService();
        List<Gys> g = gs.querySupplier(name);
        map = new HashMap<>();
        map.put("gys",g);
        return "querySimpleSuccess";
    }

    public String queryAllSupplier(){
        GysService gs = new GysService();
        map = new HashMap<>();
        map.put("gys",gs.queryAllSupplier());
        return "querySimpleSuccess";
    }
}
