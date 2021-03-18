<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="admin" class = "useBean.AdminPW" scope = "session"></jsp:useBean>	
<!DOCTYPE html>
<html>
<head>
<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta charset="UTF-8">
<title>統一發票資料管理</title>
<script src="/TWreceiptSystem/resources/js/jquery3.5.1.min.js"></script>
</head>
<body>
	<br><h1>統一發票資料管理</h1><%
	admin.loadPW();
	String adminPW = admin.getAdminPW(),
			ID = request.getParameter("ID"), PW = request.getParameter("PW"), 
			back = (String) request.getAttribute("back");
	if("y".equals(back)){
		ID = "admin";
		PW = adminPW;
	}
	if (!("admin".equals(ID))) {
		request.setAttribute("IDerr", "y");
	%><jsp:forward page="/"></jsp:forward><%
	} else if (!(adminPW.equals(PW))) {
	request.setAttribute("PWerr", "y");
	%><jsp:forward page="/"></jsp:forward><%
	}%>
	期別:&nbsp;
	<input type="text" id="time" value="ex.10901" size="6" /><p>
		號碼一:&nbsp;<input type="text" id="number1" size="6" /> 
		號碼二:&nbsp;<input type="text" id="number2" size="6" /> 
		號碼三:&nbsp;<input type="text" id="number3" size="6" /><br /> 
		特別獎:&nbsp;<input type="text" id="special1" size="6" /> 
		特獎:&nbsp;<input type="text" id="special2" 	size="6" /><br /> 
		六獎一:&nbsp;<input type="text" id="spe6num1" size="6" /> 
		六獎二:&nbsp;<input type="text" id="spe6num2" size="6" />
		六獎三:&nbsp;<input type="text" id="spe6num3" size="6" /><p />
	<input type="button" id="query" value="查詢" />&nbsp;
	<button onclick="receiptadd()">新增</button>&nbsp;
	<button onclick="receiptupdate()">修改</button>&nbsp;
	<button onclick="receiptdelete()">刪除</button><p>
	<form action="/TWreceiptSystem/pwChange" method="post">
	<input type="submit" value="變更管理者密碼">
	</form><p>
	<form action="/TWreceiptSystem" method="post">
	<input type="submit" value="登出">
	</form><p>
	<div id="message">
		<font color="#ff0000" size="5">data loading...</font>
	</div>
	<script>
	    function result(data) {
		    $("#message").html(data);
	    }
		$(document).ready(function() {
			$.ajaxSetup({
				cache : false,
			});
			$.post("queryReceipt", result);
			$("#query").click(function() {
				$.post("queryReceipt", {
					"time" : $("#time").val()
				}, result);
			});
			$("input").focus(function(){
			    $(this).css("background-color","#cccccc");
			  });
			$("input").blur(function(){
			    $(this).css("background-color","#ffffff");
			  });
		});
		function receiptadd() {
			$.ajaxSetup({
				cache : false,
			});
			$.post("addReceipt", {
				"time" : $("#time").val(),
				"number1" : $("#number1").val(),
				"number2" : $("#number2").val(),
				"number3" : $("#number3").val(),
				"special1" : $("#special1").val(),
				"special2" : $("#special2").val(),
				"spe6num1" : $("#spe6num1").val(),
				"spe6num2" : $("#spe6num2").val(),
				"spe6num3" : $("#spe6num3").val()
			}, result);
		}
		function receiptupdate() {
			$.ajaxSetup({
				cache : false,
			});
			$.post("updateReceipt", {
				"time" : $("#time").val(),
				"number1" : $("#number1").val(),
				"number2" : $("#number2").val(),
				"number3" : $("#number3").val(),
				"special1" : $("#special1").val(),
				"special2" : $("#special2").val(),
				"spe6num1" : $("#spe6num1").val(),
				"spe6num2" : $("#spe6num2").val(),
				"spe6num3" : $("#spe6num3").val()
			},result);
		}
		function receiptdelete() {
			$.ajaxSetup({
				cache : false,
			});
			$.post("deleteReceipt", {
				"time" : $("#time").val(),
			}, result);
		}
	</script>
</body>
</html>