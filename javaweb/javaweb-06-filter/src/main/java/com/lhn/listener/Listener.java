package com.lhn.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计session个数
public class Listener implements HttpSessionListener {
    //session一创建就会触发这个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 1;
        } else {
            int count = onlineCount;
            onlineCount = count + 1;
        }
        context.setAttribute("onlineCount", onlineCount);
    }

    //session一销毁就会触发这个事件
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().invalidate();
        ServletContext context = se.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        context.setAttribute("onlineCount", onlineCount);
    }
}
