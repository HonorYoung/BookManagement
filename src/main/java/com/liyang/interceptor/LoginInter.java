package com.liyang.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/*
 *@author:李洋
 *@date:2019/7/25 22:05
 */
public class LoginInter implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext act = actionInvocation.getInvocationContext();
        Map<String,Object> session = act.getSession();
        if (session.get("username") != null){
            actionInvocation.invoke();
        }
        return "relogin";
    }
}
