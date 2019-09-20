package com.liyang.commons;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/*
 *@author:李洋
 *@date:2019/7/28 17:08
 */
public class Factory {
    private static SqlSessionFactory f;
    private Factory(){}
    static {
        try{
            Reader reader = Resources.getResourceAsReader("config.xml");
            f = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return f.openSession();
    }
}
