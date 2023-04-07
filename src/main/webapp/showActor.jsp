<%@ page import="com.example.javaassignment.jdbc.ActorDao" %>
<%@ page import="com.example.javaassignment.jdbc.Actor" %><%--
  Created by IntelliJ IDEA.
  User: keon2
  Date: 7/4/2023
  Time: 8:39 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      Actor actor = ActorDao.readActor();

        System.out.println("Actor ID"+actor.getActor_id());
        System.out.println("Actor First Name"+actor.getFirst_name());
        System.out.println("Actor Last Name"+actor.getLast_name());

    %>
</body>
</html>
