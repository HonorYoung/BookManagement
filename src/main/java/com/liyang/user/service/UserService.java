package com.liyang.user.service;

import com.liyang.commons.Factory;
import com.liyang.user.entity.Stu;
import com.liyang.user.entity.StuExample;
import com.liyang.user.mapper.StuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
 *@author:李洋
 *@date:2019/7/29 9:53
 */
public class UserService {
    public boolean queryByNameAndPass(Stu u) {
        SqlSession session = null;
        try{
            session = Factory.getSession();
            StuMapper dao  =session.getMapper(StuMapper.class);
            StuExample example = new StuExample();
            StuExample.Criteria cri = example.createCriteria();
            cri.andNameEqualTo(u.getName());
            cri.andPwdEqualTo(u.getPwd());
            List<Stu> user = dao.selectByExample(example);
            session.commit();
            return user != null;
        }catch(Exception e){
            e.printStackTrace();
            if (session != null){
                session.rollback();
                return false;
            }
        }finally{
            if (session != null){
                session.close();
            }
        }
        return false;
    }
}
