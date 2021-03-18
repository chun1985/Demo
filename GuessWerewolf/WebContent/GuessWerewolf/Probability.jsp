<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:useBean id="gww" class="com.sample15.GuessWerewolf" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>拿狼機率</title>
</head>
<body>
<br><jsp:include page="/Profile/Profile.jsp"/>
<h1>拿狼機率</h1>
<form action = "Probability.jsp" method = "post">
<input type = "radio" name = "work" value = "1" checked />新增 10 筆資料<br>
<input type = "radio" name = "work" value = "2"  />查詢每位玩家拿狼機率<br>
<input type = "radio" name = "work" value = "3"  />查詢
<select id= "sel1" name="player">
<option value="1" selected>玩家1</option>
<option value="2" >玩家2</option>
<option value="3" >玩家3</option>
<option value="4" >玩家4</option>
<option value="5" >玩家5</option>
<option value="6" >玩家6</option>
<option value="7" >玩家7</option>
<option value="8" >玩家8</option>
<option value="9" >玩家9</option>
<option value="10" >玩家10</option>
</select>
各角色機率<br>
<input type = "radio" name = "work" value = "4" />第
<input type = "text" name ="round" size ="1"/>
 回合重新分配<br>
<input type = "radio" name = "work" value = "5" />刪除 10 筆資料<br>
<input type = "radio" name = "work" value = "6" />清除所有資料<p>
<input type = "submit" value = "送出" ></form>
<%
String work = request.getParameter("work");
String player = request.getParameter("player");
String round = request.getParameter("round");
if("1".equals(work)){
    gww.toSetCharacter();
    out.print(gww.getResult());
}else if("2".equals(work)){
	gww.toQuery("0");
    out.print(gww.getResult());
}else if("3".equals(work)){
	gww.toQuery(player);
	out.print(gww.getResult());
}else if("4".equals(work)){
	gww.toUpData(round);
	out.print(gww.getResult());
}else if("5".equals(work)){
	gww.toDeleteData();
	out.print(gww.getResult());
}else if("6".equals(work)){
	gww.toDropTable();
	out.print(gww.getResult());
}%>
<script>
$(document).ready(function(){
	  $("#sel1").addClass("font2");
	});
</script>
</body>
</html>