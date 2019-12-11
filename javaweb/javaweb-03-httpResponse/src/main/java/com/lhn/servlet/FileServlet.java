package com.lhn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //获取下载文件的路径
        String realPath = "/Users/lhn/Desktop/project/javaweb/javaweb-03-httpResponse/target/javaweb-03-httpResponse/WEB-INF/classes/Spring学习笔记.md";
        System.out.println("下载文件的路径:" + realPath);
        //下载文件的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
        //让浏览器支持
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        //获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //获取outputstream
        ServletOutputStream outputStream = resp.getOutputStream();
        //将fileoutputsteam写入缓冲区,将缓冲区数据输出到客户端
        while ((len = fileInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        //关闭
        fileInputStream.close();
        outputStream.close();
    }
}
