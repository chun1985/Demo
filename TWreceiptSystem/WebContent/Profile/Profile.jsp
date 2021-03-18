<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<script type="text/javascript" src="/TWreceiptSystem/resources/js/jquery3.5.1.min.js"></script>
<style type="text/css">
    .color1 {background-color : #ffe1ab }
    .color2 {background-color : #abffff }
    .color3 {background-color : #dbabff }
    .font1{font-size : 0.6cm}
    .font2{font-size : 0.4cm}
</style>
<p><b id="b1">履歷書</b>&nbsp;<button id = "butt1" >隱藏 / 顯示</button><p>
<div id="div1" style="display:none">
<b id="b2">基本資料:</b>
<table border ="1" >
<tr id = "tr1" ><td align = "center" width = "110"> <b>姓 名:</b></td><td align = "center"  width = "384"><b>李   家   準</b></td></tr>
<tr><td align = "center"><b>生 日:</b></td><td align = "center">1985 年 08 月 04 日 ( 35歲 )</td></tr>
<tr><td align = "center"><b>性 別:</b></td><td align = "center" >男</td></tr>
<tr><td align = "center"><b>兵 役:</b></td><td align = "center" >役   畢 ( 2011 年 08 月 )</td></tr>
</table>
<br><b id="b3">學歷:</b>
<table border ="1" >
<tr id = "tr2" ><td align = "center" width = "110"><b>留  學</b></td><td align = "center" width = "240"><b>東京國際大學<br>附屬日本語學校</b></td><td> 2011 / 10 ~ 2013 / 09 </td></tr>
<tr id = "tr3" ><td align = "center"><b>研 究 所</b></td><td align = "center"><b>聖約翰科技大學</b></td><td> 2008 / 09 ~ 2010 / 07 </td></tr>
<tr><td align = "center" ><b>大  學</b></td><td align = "center">聖約翰科技大學</td><td> 2003 / 09 ~ 2008 / 06 </td></tr>
<tr><td align = "center" ><b>高  中</b></td><td align = "center" >開 南 商 工</td><td> 2000 / 09 ~ 2003 / 06 </td></tr>
</table>
<br><b id="b4">工作經歷:</b>
<table border ="1" >
<tr id = "tr4" ><td align = "center" ><b>和 新 機 電</b></td><td align = "center" width = "50" >台 灣</td><td align = "center"><b>電力機械修配業</b></td><td align = "center" ><b>機 電 員</b></td><td> 2019 / 05 ~  </td></tr>
<tr><td><b>日商住重電子</b></td><td align = "center" width = "50">台 灣</td><td align = "center"><b>醫 療 器 材</b></td><td><b>客服工程師</b></td><td> 2017 / 09 ~ 2018 / 11 </td></tr>
<tr><td align = "center" ><b>日 商 住 吉</b></td><td align = "center" width = "50">日 本</td><td align = "center"><b>鐵 道 工 程</b></td><td align = "center" ><b>技 術 員</b></td><td> 2014 / 03 ~ 2017 / 02 </td></tr>
</table>
</div>
<script>
$(document).ready(function(){
	  $("#tr1").addClass("color1");
	  $("#tr2,#tr3").addClass("color2");
	  $("#tr4").addClass("color3");
	  $("#b1,#b2,#b3,#b4").addClass("font1");
	  $("#butt1").addClass("font2");
	  $("#butt1").click(function(){
		    $("#div1").toggle();
		  });
	});
</script>
</body>
</html>