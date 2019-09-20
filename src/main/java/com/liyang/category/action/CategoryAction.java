package com.liyang.category.action;

import com.liyang.category.entity.Category;
import com.liyang.category.service.CategoryService;
import com.liyang.commons.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
 *@author:李洋
 *@date:2019/7/29 15:05
 */
public class CategoryAction {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Page<Category> page;

    public Page<Category> getPage() {
        return page;
    }

    private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setPage(Page<Category> page) {
        this.page = page;
    }

    public String addCategory(){
        CategoryService cs = new CategoryService();
        Category ca = new Category();
        ca.setId(UUID.randomUUID().toString().replaceAll("-",""));
        ca.setName(name);
        cs.addCategory(ca);
        return "addSuccess";
    }

    public String queryCategory(){
        CategoryService cs = new CategoryService();
        List<Category> data = cs.queryCategory(name);
        map = new HashMap<>();
        map.put("cate",data);
        return "querySimpleSuccess";
    }
    private int pageNumber;
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String querySomeCategory(){
        CategoryService gs = new CategoryService();
        page = new Page<>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        page.setTotal(gs.queryCount());
        page.setRows(gs.querySomeCategory(page.getStart(),pageSize));
        return "querySuccess";

    }
    public String queryAllCategory(){
        CategoryService gs = new CategoryService();
        map = new HashMap<>();
        map.put("cate",gs.queryAllCategory());
        return "querySimpleSuccess";
    }
}
