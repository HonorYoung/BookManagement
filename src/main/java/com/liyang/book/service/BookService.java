package com.liyang.book.service;

import com.liyang.book.entity.Book;
import com.liyang.book.entity.BookExample;
import com.liyang.book.entity.Bookpic;
import com.liyang.book.entity.BookpicExample;
import com.liyang.book.mapper.BookMapper;
import com.liyang.book.mapper.BookpicMapper;
import com.liyang.commons.ETUtils;
import com.liyang.commons.Factory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/29 17:17
 */
public class BookService {
    public void addBook(Book book) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);
            dao.insert(book);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            if (session != null){
                session.rollback();
            }
        }finally{
            if (session != null){
                session.close();
            }
        }
    }

    public int queryCount(Map<String, Object> tj) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);

            int count = dao.queryCount(tj);
            session.commit();
            return count;
        }catch(Exception e){
            e.printStackTrace();
            if (session != null){
                session.rollback();
                return 0;
            }
        }finally{
            if (session != null){
                session.close();
            }
        }
        return 0;
    }

    public List<Book> querySome(Map<String, Object> map) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);
            List<Book> data = dao.querySome(map);
            session.commit();
            return data;
        }catch(Exception e){
            e.printStackTrace();
            if (session != null){
                session.rollback();
                return null;
            }
        }finally{
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    public Book queryByIdWithPics(String id) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);
            Book book = dao.queryByIdWithPics(id);
            session.commit();
            return book;
        }catch(Exception e){
            e.printStackTrace();
            if (session != null){
                session.rollback();
                return null;
            }
        }finally{
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    public void addPic(Bookpic bp) {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookpicMapper dao = session.getMapper(BookpicMapper.class);
            dao.insert(bp);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Object queryPicsById(String bookid) {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookpicMapper dao = session.getMapper(BookpicMapper.class);
            BookpicExample example = new BookpicExample();
            example.createCriteria().andBookidEqualTo(bookid);
            List<Bookpic> data = dao.selectByExample(example);
            session.commit();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
                return null;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public void delPic(String bpid) {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookpicMapper dao = session.getMapper(BookpicMapper.class);
            BookpicExample example = new BookpicExample();
            example.createCriteria().andIdEqualTo(bpid);
            dao.deleteByExample(example);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void setPicAsFM(String bpid) {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookpicMapper dao = session.getMapper(BookpicMapper.class);
            BookpicExample example = new BookpicExample();
            example.createCriteria().andIdEqualTo(bpid);
            dao.setPicNotAsFM();
            dao.setPicAsFM(bpid);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int queryCountById(String bid) {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);
            BookExample example = new BookExample();
            int count  = dao.queryCountById(bid);
            session.commit();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
                return 0;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return 0;
    }

    public int queryCountToCustomer() {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);
            BookExample example = new BookExample();
            int count  = dao.queryCountToCustomer();
            session.commit();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
                return 0;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return 0;
    }

    public List<Book> showToCustomer(Map<String, Object> map) {
        SqlSession session = null;
        try {
            session = Factory.getSession();
            BookMapper dao = session.getMapper(BookMapper.class);
            BookExample example = new BookExample();
            List<Book> data = dao.showToCustomer(map);
            session.commit();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
                return null;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
