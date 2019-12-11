package com.lhn.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //自动刷新
        resp.setHeader("refresh", "3");
        //在内存中创建图片
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        //图片背景颜色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 80, 20);
        //写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeString(),0,20);

        //告诉浏览器用图片方式打开
        resp.setContentType("image/jpeg");
        //网站有缓冲,关闭功能
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //图片给浏览器
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());

    }

    private String makeString() {
        Random random = new Random();
        String string = random.nextInt(9999999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7 - string.length(); i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.toString() + string;
    }
}
