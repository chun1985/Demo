<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<% request.setAttribute("back", "y"); %>
<jsp:forward page="/receiptData"></jsp:forward>
</body>
</html>