package com.lhn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if (user_session==null){
            resp.sendRedirect("/error.jsp");
        }


        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
