package com.liyang.category.service;

import com.liyang.category.entity.Category;
import com.liyang.category.entity.CategoryExample;
import com.liyang.category.mapper.CategoryMapper;
import com.liyang.commons.Factory;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/29 15:10
 */
public class CategoryService {
    public void addCategory(Category ca) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            CategoryMapper dao = session.getMapper(CategoryMapper.class);
            dao.insert(ca);
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

    public List<Category> queryCategory(String name) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            CategoryMapper dao = session.getMapper(CategoryMapper.class);
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(name);
            List<Category> data = dao.selectByExample(example);
            session.commit();
            return data;
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
        return null;
    }

    public int queryCount() {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            CategoryMapper dao = session.getMapper(CategoryMapper.class);
            int count = dao.countByExample(null);
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

    public List<Category> querySomeCategory(int start, int pageSize) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            CategoryMapper dao = session.getMapper(CategoryMapper.class);
            Map<String,Object> map = new HashMap<>();
            map.put("start",start);
            map.put("end",start+pageSize);
            List<Category> data = dao.querySome(map);
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

    public List<Category> queryAllCategory() {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            CategoryMapper dao = session.getMapper(CategoryMapper.class);
            List<Category> cate = dao.selectByExample(null);
            session.commit();
            return cate;
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
}
