package com.liyang.gys.service;

import com.liyang.commons.Factory;
import com.liyang.gys.entity.City;
import com.liyang.gys.entity.Province;
import com.liyang.gys.mapper.CityMapper;
import com.liyang.gys.mapper.ProvinceMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
 *@author:李洋
 *@date:2019/7/24 20:39
 */
public class AddressService {
    public List<Province> queryProvince() {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            ProvinceMapper dao = session.getMapper(ProvinceMapper.class);
            List<Province> data = dao.selectByExample(null);
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


    public List<City> queryCity(String provinceName) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            CityMapper dao = session.getMapper(CityMapper.class);
            List<City> data = dao.queryByPname(provinceName);
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
}
