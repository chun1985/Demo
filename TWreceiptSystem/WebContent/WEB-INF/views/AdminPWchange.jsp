<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="admin" class="useBean.AdminPW" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系統管理人密碼變更</title>
<script src="/TWreceiptSystem/resources/js/jquery3.5.1.min.js"></script>
</head>
<body>
	<br>	<h1>系統管理人密碼變更</h1>
	<form action="/TWreceiptSystem/pwChange" method="post">
		請輸入密碼:&nbsp;<input type="password" name="opw" size="6">	<p>
		請輸入新密碼:&nbsp;<input type="password" name="npw1" size="6"><p>
		請再輸入一次新密碼:&nbsp;<input type="password" name="npw2" size="6"><p>
		<input type="submit" value="密碼變更">
	</form><p>
	<form action="/TWreceiptSystem/pwChangeOut" method="post">
		<input type="submit" value="離開">
	</form><p>
		<%
		String adminPW, opw = request.getParameter("opw"), npw1 = request.getParameter("npw1"),
				npw2 = request.getParameter("npw2");
		admin.loadPW();
		adminPW = admin.getAdminPW();
		//out.print("密碼為: <font color='#ff0000'>" + adminPW + "</font><br>");
		if (opw != "" && opw != null && npw1 != "" && npw1 != null && npw2 != "" && npw2 != null) {
			if (adminPW.equals(opw)) {
				if (!(opw.equals(npw1))) {
			if (admin.cheakPWfont(npw1)) {
				if (npw1.equals(npw2)) {
					admin.setAdminPW(npw1);
					admin.savePW();
					out.print("<font color='#ff0000'>密碼變更成功.....</font>");
					if(npw1.length()>5){
					out.print("<br>新密碼為: <font color='#ff0000'>" + npw1.substring(0,3) + "************</font>");
					}
				} else {
					out.print("<font color='#ff0000'>新密碼輸入不一致</font>");
				}
			} else {
				out.print("<font color='#ff0000'>新密碼必須包含大小寫英文字母及數字</font>");
			}
				} else {
			out.print("<font color='#ff0000'>新密碼與舊密碼相同</font>");
				}
			} else {
				out.print("<font color='#ff0000'>密碼輸入錯誤</font>");
			}
		} else if (opw == "" || npw1 == "" || npw2 == "") {
			out.print("<font color='#ff0000'>欄位不可空白</font>");
		}%>
		<script type="text/javascript">
		$(document).ready(function() {
		    $("input").focus(function(){
			    $(this).css("background-color","#cccccc");
			  });
			$("input").blur(function(){
			    $(this).css("background-color","#ffffff");
			  });
		});
		</script>  
</body>
</html>