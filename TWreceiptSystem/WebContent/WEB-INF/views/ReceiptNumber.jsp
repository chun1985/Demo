<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page errorPage="ErrorMsg.jsp"%>
<jsp:useBean id="rc" class="useBean.ReceiptLottery" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>統一發票對獎</title>
<script src="/TWreceiptSystem/resources/js/jquery3.5.1.min.js"></script>
</head>
<body>
<br><h1>統一發票對獎</h1>
<%
String time = request.getParameter("time");
if(time == null){
	time = (String ) session.getAttribute("time");
}
else{	
	session.setAttribute("time", time);
}
if (time != "" && time != null ) {
out.print("<font color='##0000ff'>" + time.substring(0, 3) + "</font> 年 <font color='#ff0000'>" + time.substring(3, 5) + "</font> 月開獎");
}%><p>
<form action = "/TWreceiptSystem/receiptNumber" method ="post">
號碼1:&nbsp;<input type = "text" name = "number1" size = "5"><br>
號碼2:&nbsp;<input type = "text" name = "number2" size = "5"><br>
號碼3:&nbsp;<input type = "text" name = "number3" size = "5"><br>
號碼4:&nbsp;<input type = "text" name = "number4" size = "5"><br>
號碼5:&nbsp;<input type = "text" name = "number5" size = "5"><p>
<input type = "submit" value = "送出">
</form><p>
<form action = "/TWreceiptSystem" method ="post">
<input type = "submit" value = "重新選擇月份">
</form><p>
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
<%
String number1 = request.getParameter("number1"), number2 = request.getParameter("number2"),
number3 = request.getParameter("number3"), number4 = request.getParameter("number4"),
number5 = request.getParameter("number5");
boolean notAllNull = (number1 != null && number1 !="") || (number2 != null && number2 !="") || 
(number3 != null && number3 !="") || (number4 != null && number4 !="") || 
(number5 != null && number5 !=""),
allNull = number1 =="" && number2 ==""&& number3 =="" && number4 =="" && number5 =="";
String [] number = new String []{number1,number2,number3,number4,number5};
if(notAllNull){
for(int i=0; i<number.length; i++){
	if((!number[i].matches("[0-9]+")) && number [i] != "" ){
		String msg = "輸入內容包含英文或其他符號";
		throw new Exception(msg);
	}else{    
		if(number[i].length() > 8 && number [i] != ""){
			String msg = "輸入數字超過8位數";
			throw new Exception(msg);
		}else if(number[i].length() < 8 && number [i] != ""){
		    String msg = "輸入數字少於8位數";
			throw new Exception(msg);
		}
	}
}
for(int i=0; i<number.length; i++){
	if(number [i] != ""){
	rc.setUserTime(time);
    rc.setUserNum(number [i]);
    rc.doResult();
    out.print(rc.getTheResult()+"<br>");
    }
}
}else if(allNull){
	out.print("<font color='#ff0000'>請輸入號碼</font>");
}else if(time == ""){
request.setAttribute("nullMsg", "y");%>
<jsp:forward page="/"></jsp:forward><%
}%>
</body>
</html>