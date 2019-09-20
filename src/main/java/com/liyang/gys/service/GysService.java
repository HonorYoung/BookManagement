package com.liyang.gys.service;

import com.liyang.commons.Factory;
import com.liyang.gys.entity.City;
import com.liyang.gys.entity.Gys;
import com.liyang.gys.entity.GysExample;
import com.liyang.gys.entity.Province;
import com.liyang.gys.mapper.CityMapper;
import com.liyang.gys.mapper.GysMapper;
import com.liyang.gys.mapper.ProvinceMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/29 9:35
 */
public class GysService {
    public void addSupplier(Gys gys) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            GysMapper dao = session.getMapper(GysMapper.class);
            dao.insert(gys);
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

    public int queryCount(Map<String,Object> map) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            GysMapper dao = session.getMapper(GysMapper.class);
            int count = dao.queryCount(map);
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

    public List<Gys> querySomeSupplier(Map<String,Object> map, int start, int pageSize) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            GysMapper dao = session.getMapper(GysMapper.class);
            map.put("start",start);
            map.put("end",pageSize+start);
            List<Gys> data = dao.querySome(map);
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

    public List<Gys> querySupplier(String name) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            GysMapper dao = session.getMapper(GysMapper.class);
            GysExample example = new GysExample();
            GysExample.Criteria cri = example.createCriteria();
            cri.andNameEqualTo(name);
            List<Gys> gys = dao.selectByExample(example);
            session.commit();
            return gys;
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

    public List<Gys> queryAllSupplier() {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            GysMapper dao = session.getMapper(GysMapper.class);
            List<Gys> gys = dao.selectByExample(null);
            session.commit();
            return gys;
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
