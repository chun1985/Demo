<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Product Registration Form</title>

<style>
	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<br><h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="products">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name" size = "5"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="price">price: </label> </td>
				<td><form:input path="price" id="price" size = "5"/></td>
				<td><form:errors path="price" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="quantity">quantity: </label> </td>
				<td><form:input path="quantity" id="quantity" size = "5"/></td>
				<td><form:errors path="quantity" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<br><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Products</a>
</body>
</html>