package com.liyang.commons;

import java.util.List;

//该组件存放所有与分页相关的内容
public class Page<T> {
    private int pageNumber;  //当前页
    private int pageSize;    //每页的记录数
    private int total;       //总记录数
        private int pageCount;   //总页数

        private int pre;        //上一页
        private int next;        //下一页
        private int start;       //起始位置
    private List<T> rows;   //当前页显示的数据

       private boolean  first;
       private boolean  last;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return (total+pageSize-1)/pageSize;
    }
    public int getPre() {
        if(pageNumber>1)
        return pageNumber-1;
        return 1;
    }
    public int getNext() {
        if(pageNumber<getPageCount())
        return pageNumber+1;
        return getPageCount();
    }
    public int getStart() {
        return (pageNumber-1)*pageSize;
    }
    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public boolean isFirst() {
        return pageNumber==1;
    }
    public boolean isLast() {
        return pageNumber==getPageCount();
    }

}
