package com.liyang.shopping.entity;
/*
 * Project name:Book
 * Author:LiYang
 * Date:2019/7/18:14:39
 */

import com.liyang.book.entity.Book;
import com.liyang.book.service.BookService;

//在购物车计算的过程中，需要不属于书籍属性的信息
public class Lanzi {
    private Book book;
    private int count;
    private double sum;

    public void addOne(String bid){
        BookService bs = new BookService();
        if (count < bs.queryCountById(bid)){
            count ++;
        }
    }
    public void removeOne(){
        count --;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return book.getPrice()*count;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
