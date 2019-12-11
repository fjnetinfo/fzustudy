package com.lhn.servlet.user;

import com.lhn.pojo.User;
import com.lhn.service.user.UserService;
import com.lhn.service.user.UserServiceImpl;
import com.lhn.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        try {
            User user = userService.login(userCode, userPassword);
            if (user!=null){
                req.getSession().setAttribute(Constants.USER_SESSION,user);
                resp.sendRedirect("jsp/frame.jsp");
            }else {
                req.setAttribute("error","用户名或密码不正确");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
