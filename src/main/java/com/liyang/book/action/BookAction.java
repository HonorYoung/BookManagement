package com.liyang.book.action;

import com.liyang.book.entity.Book;
import com.liyang.book.entity.Bookpic;
import com.liyang.book.service.BookService;
import com.liyang.book.service.BookpicService;
import com.liyang.commons.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
 *@author:李洋
 *@date:2019/7/29 17:08
 */
public class BookAction extends ActionSupport {
    private Book b;
    private File[] pic;
    private String[] picFileName;
    private String[] picContentType;
    private Page<Book> page;
    private int pageNumber;
    private int pageSize;
    private String bookname;
    private String category;
    private String gys;
    private int price_min;
    private int price_max;
    private Date publishdate_start;
    private Date publishdate_end;

    public File[] getPic() {
        return pic;
    }

    public void setPic(File[] pic) {
        this.pic = pic;
    }

    public String[] getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String[] picFileName) {
        this.picFileName = picFileName;
    }

    public String[] getPicContentType() {
        return picContentType;
    }

    public void setPicContentType(String[] picContentType) {
        this.picContentType = picContentType;
    }

    public Page<Book> getPage() {
        return page;
    }

    public void setPage(Page<Book> page) {
        this.page = page;
    }

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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGys() {
        return gys;
    }

    public void setGys(String gys) {
        this.gys = gys;
    }

    public int getPrice_min() {
        return price_min;
    }

    public void setPrice_min(int price_min) {
        this.price_min = price_min;
    }

    public int getPrice_max() {
        return price_max;
    }

    public void setPrice_max(int price_max) {
        this.price_max = price_max;
    }

    public Date getPublishdate_start() {
        return publishdate_start;
    }

    public void setPublishdate_start(Date publishdate_start) {
        this.publishdate_start = publishdate_start;
    }

    public Date getPublishdate_end() {
        return publishdate_end;
    }

    public void setPublishdate_end(Date publishdate_end) {
        this.publishdate_end = publishdate_end;
    }

    public Book getB() {
        return b;
    }

    public void setB(Book b) {
        this.b = b;
    }

    private Map<String,Object> map;

    public String addBook() throws Exception{
        Book book = new Book();
        book.setId(UUID.randomUUID().toString().replaceAll("-",""));
        book.setAuthor(b.getAuthor());
        book.setCategoryid(b.getCategoryid());
        book.setDel(Short.parseShort("0"));
        book.setGysid(b.getGysid());
        book.setName(b.getName());
        book.setPrice(b.getPrice());
        book.setStatus(b.getStatus());
        book.setPublishdate(b.getPublishdate());
        //book.setPdate(b.getPdate().toString());
        /*book.setPublishdate(new Timestamp(DateUtils.parseDate(b.getPublishdate().toString(),
                new String[]{"yyyy-MM-dd hh:mm:ss.S"}).getTime()));*/
        BookService bs = new BookService();
        bs.addBook(book);
        if (pic != null){
            for (int i = 0;i < pic.length;i++){
                File f = pic[i];
                BookService bss = new BookService();
                Bookpic bp = new Bookpic();
                String newName = UUID.randomUUID().toString().
                        replaceAll("-","")+"."+ FilenameUtils.getExtension(picFileName[i]);
                bp.setBookid(book.getId());
                bp.setId(UUID.randomUUID().toString().replaceAll("-",""));
                bp.setSavepath("/files/"+newName);
                if (i == 0){
                    bp.setFm(Short.parseShort("1"));
                }else {
                    bp.setFm(Short.parseShort("0"));
                }
                bp.setShowname(picFileName[i]);
                bp.setUploadtime(new Timestamp(System.currentTimeMillis()));
                bss.addPic(bp);
                InputStream is = new FileInputStream(f);
                ServletContext application = ServletActionContext.getServletContext();
                String path = application.getRealPath("/files/"+newName);
                OutputStream os = new FileOutputStream(new File(path));
                IOUtils.copy(is,os);
             }
        }

        return "addSuccess";
    }

    public String querySomeBook(){
        map = new HashMap<>();
        map.put("bookname",bookname);
        map.put("categoryid",category);
        map.put("gysid",gys);
        map.put("price_min",price_min);
        map.put("price_max",price_max);
        map.put("publishdate_start",publishdate_start);
        map.put("publishdate_end",publishdate_end);
        page = new Page<>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        map.put("start",page.getStart());
        map.put("end",pageSize+page.getStart());
        BookService bs = new BookService();
        page.setTotal(bs.queryCount(map));
        page.setRows(bs.querySome(map));
        return "querySuccess";
    }

    private String bookid;
    private String bpid;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBpid() {
        return bpid;
    }

    public void setBpid(String bpid) {
        this.bpid = bpid;
    }

    public String queryPicsByPid(){
        BookService bs = new BookService();
        map = new HashMap<>();
        map.put("bps",bs.queryPicsById(bookid));
        return "success";
    }

    public String addPic() throws Exception{
        if (pic != null){
            for (int i = 0;i < pic.length;i++){
                File f = pic[i];
                BookService bss = new BookService();
                Bookpic bp = new Bookpic();
                String newName = UUID.randomUUID().toString().
                        replaceAll("-","")+"."+ FilenameUtils.getExtension(picFileName[i]);
                bp.setBookid(bookid);
                bp.setId(UUID.randomUUID().toString().replaceAll("-",""));
                bp.setSavepath("/files/"+newName);
                bp.setFm(Short.parseShort("0"));
                bp.setShowname(picFileName[i]);
                bp.setUploadtime(new Timestamp(System.currentTimeMillis()));
                bss.addPic(bp);
                InputStream is = new FileInputStream(f);
                ServletContext application = ServletActionContext.getServletContext();
                String path = application.getRealPath("/files/"+newName);
                OutputStream os = new FileOutputStream(new File(path));
                IOUtils.copy(is,os);
            }
        }
        map = new HashMap<>();
        map.put("flag","success");
        return "success";
    }

    public String delPic(){
        BookService bs = new BookService();
        bs.delPic(bpid);
        map = new HashMap<>();
        map.put("bps","success");
        return "success";
    }

    public String setPicAsFm(){
        BookService bs = new BookService();
        bs.setPicAsFM(bpid);
        map = new HashMap<>();
        map.put("bps","success");
        return "success";
    }
}
