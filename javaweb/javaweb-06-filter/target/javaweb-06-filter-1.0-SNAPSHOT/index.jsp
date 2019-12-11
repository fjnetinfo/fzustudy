<%--
  Created by IntelliJ IDEA.
  User: lhn
  Date: 2019/11/30
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>当前有<span><%=this.getServletConfig().getServletContext().getAttribute("onlineCount")%>个人在线</span></h1>
  </body>
</html>
