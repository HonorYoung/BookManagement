package com.liyang.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *@author:李洋
 *@date:2019/7/28 14:57
 */
public class ETUtils {
    public static Date string2Date(String date){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
