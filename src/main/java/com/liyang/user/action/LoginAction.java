package com.liyang.user.action;

import com.liyang.user.entity.Stu;
import com.liyang.user.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 *@author:李洋
 *@date:2019/7/25 21:09
 */
public class LoginAction {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        UserService us = new UserService();
        Stu u = new Stu();
        u.setName(username);
        u.setPwd(password);
        if (us.queryByNameAndPass(u)){
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            return "login_success";
        }
        return "relogin";
    }

    public String main(){
        return "success";
    }
}
