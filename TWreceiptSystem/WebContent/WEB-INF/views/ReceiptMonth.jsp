<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    .font3{font-size : 0.5cm}
</style>
<meta charset="utf-8">
<title>請選擇開講月份</title>
</head>
<body>
<br><jsp:include page="/Profile/Profile.jsp"/> 
<p><b id="b5">管理者登入</b>&nbsp;<button id = "butt2" >隱藏 / 顯示</button><p>
<div id="div2" style="display:none">
<form action = "/TWreceiptSystem/receiptData" method ="post">
管理者帳號:&nbsp;<input type = "text" name = "ID" size = "5">
管理者密碼:&nbsp;<input type = "password" name = "PW" size = "5">
<input type = "submit" value = "登入">
</form><p>
</div>
<%
String IDerr = (String) request.getAttribute("IDerr"), PWerr = (String) request.getAttribute("PWerr");
if("y".equals(IDerr)){
	out.print("<font color='#ff0000'>帳號輸入錯誤</font>");
}else if("y".equals(PWerr)){
	out.print("<font color='#ff0000'>密碼輸入錯誤</font>");
}%>
<h1>統一發票對獎</h1>
<h2>請選擇開講月份</h2>
<% 
session.removeAttribute("time");
%>
<form action = "/TWreceiptSystem/receiptNumber" method ="post">
<select id="sec1" name="time">
<option value="10801">108年01月開獎</option>
<option value="10803">108年03月開獎</option>
<option value="10805">108年05月開獎</option>
<option value="10807">108年07月開獎</option>
<option value="10809">108年09月開獎</option>
<option value="10811">108年11月開獎</option>
<option value="10901">109年01月開獎</option>
<option value="10903">109年03月開獎</option>
<option value="" selected >請選擇開獎月份</option>
</select>
<input type = "submit" value = "送出">
</form><p>
<script>
$(document).ready(function(){
	  $("#sec1").addClass("font3");
	  $("#b5").addClass("font1");
	  $("#butt2").addClass("font2");
	  $("#butt2").click(function(){
		    $("#div2").toggle();
		  });
	  $("input").focus(function(){
		    $(this).css("background-color","#cccccc");
		  });
	  $("input").blur(function(){
		    $(this).css("background-color","#ffffff");
		  });
	});
</script>
<% 
String nullMsg = (String) request.getAttribute("nullMsg");
if("y".equals(nullMsg) ){
out.print("<font color='#ff0000'>請選擇開獎月份</font>");
}%>
</body>
</html>