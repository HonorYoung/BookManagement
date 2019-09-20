package com.liyang.shopping.action;

import com.liyang.book.entity.Book;
import com.liyang.book.service.BookService;
import com.liyang.commons.Page;
import com.liyang.shopping.entity.Lanzi;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/29 22:17
 */
public class ShopAction {
    private int pageSize;
    private int pageNumber;
    private Page<Book> page;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Page<Book> getPage() {
        return page;
    }

    public void setPage(Page<Book> page) {
        this.page = page;
    }

    public String showBooksToCustomer(){
        page = new Page<>();
        BookService bs = new BookService();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("start",page.getStart());
        map.put("end",pageSize+page.getStart());
        page.setTotal(bs.queryCountToCustomer());
        page.setRows(bs.showToCustomer(map));
        return "success";
    }
private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String removeOne(){
        HttpServletRequest request = ServletActionContext.getRequest();
        BookService bs = new BookService();
        HttpSession session = request.getSession();
        Map<String,Lanzi> car = (HashMap<String, Lanzi>)session.getAttribute("car");
        Lanzi lz = car.get(id);
        lz.addOne(id);
        car.put(id,lz);
        session.setAttribute("car",car);
        map = new HashMap<>();
        map.put("flag","success");
        return "addsuccess";
    }

    public String addOne(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Map<String,Lanzi> car = (HashMap<String, Lanzi>)session.getAttribute("car");
        Lanzi lz = car.get(id);
        lz.removeOne();
        car.put(id,lz);
        if (lz.getCount() < 1){
            car.remove(id);
        }
        session.setAttribute("car",car);
        map = new HashMap<>();
        map.put("flag","success");
        return "addsuccess";
    }
    public String addCar(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String bid = request.getParameter("bid");
        BookService bs = new BookService();
        Book book = bs.queryByIdWithPics(bid);
        //从session获得购物车(要想加入购物车，首先要有购物车)
        HttpSession session = request.getSession();
        Map<String, Lanzi> car = (HashMap<String, Lanzi>)session.getAttribute("car");
        //没有购物车
        if (car == null){
            //创建新的购物车
            car = new HashMap<String, Lanzi>();
            //创建新的篮子
            Lanzi lz = new Lanzi();
            //把书放在篮子里
            lz.setBook(book);
            lz.addOne(bid);
            //篮子放车里
            car.put(bid,lz);
        }else {
            //根据书籍id获得篮子
            Lanzi lz = car.get(bid);
            //没有买过本商品
            if (lz == null){
                lz = new Lanzi();
                lz.setBook(book);
                lz.addOne(bid);
            }else {
                lz.addOne(bid);

            }
            car.put(bid,lz);
        }
        //车放session里
        session.setAttribute("car",car);
        map = new HashMap<>();
        map.put("flag","success");
        return "addsuccess";
    }
}
