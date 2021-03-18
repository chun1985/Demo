<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>
	<table border="1">
		<th>期別</th>
		<th>號碼一</th>
		<th>號碼二</th>
		<th>號碼三</th>
		<th>特別獎</th>
		<th>特獎</th>
		<th>六獎一</th>
		<th>六獎二</th>
		<th>六獎三</th>
		<c:forEach items="${message}" var="Receipt">
			<tr>
				<td>${Receipt.time}</td>
				<td>${Receipt.number1}</td>
				<td>${Receipt.number2}</td>
				<td>${Receipt.number3}</td>
				<td>${Receipt.special1}</td>
				<td>${Receipt.special2}</td>
				<td>${Receipt.spe6num1}</td>
				<td>${Receipt.spe6num2}</td>
				<td>${Receipt.spe6num3}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>