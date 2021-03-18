<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>錯誤訊息</title>
</head>
<body>
<br><h1>錯誤訊息</h1>
<%
out.println("<table border ='1'>");
out.println("<tr><td>code:</td><td>" + request.getAttribute("javax.servlet.error.status_code") + "</td></tr>");
out.println("<tr><td>exception:</td><td><font color='#ff8000'>" + request.getAttribute("javax.servlet.error.exception") + "</font></td></tr>");
out.println("<tr><td>URL:</td><td><font color='#ff0000'>" + request.getAttribute("javax.servlet.error.request_uri") + "</font></td></tr>");
%>
<form  action = "/TWreceiptSystem/receiptNumber" method = "post">
<input type = "submit" value = "回查詢頁面"/>
</form><p>
</body>
</html>