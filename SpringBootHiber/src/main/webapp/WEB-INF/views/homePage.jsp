<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>List of Products</title>
<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>
<body>
	<br><h2>List of Products</h2>
	<table>
		<tr>
			<td align ="center">Name</td>
			<td align ="center">Price</td>
			<td align ="center">Quantity</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${products}" var="products">
			<tr>
				<td align ="center">${products.name}</td>
				<td align ="center">${products.price}</td>
				<td align ="center">${products.quantity}</td>
				<td><a href="<c:url value='/edit/${products.name}'/>">edit</a></td>
				<td><a href="<c:url value='/delete/${products.id}'/>">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/new' />">Add New Products</a>
</body>