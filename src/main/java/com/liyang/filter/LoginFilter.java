package com.liyang.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 *@author:李洋
 *@date:2019/7/25 21:29
 */

//@WebFilter(urlPatterns = "*.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse)resp;

        String url = request.getRequestURL().toString();
        if (url.indexOf("login.jsp") >= 0){
            chain.doFilter(req, resp);
            return;
        }else if (session.getAttribute("username") != null){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
