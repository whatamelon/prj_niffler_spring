<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.Calendar"%>
<%@page import="java.io.IOException"%>

<!--  JSP에서 jsoup을 사용하기 위해 import -->

<%@ page import="org.jsoup.Jsoup"%>

<%@ page import="org.jsoup.nodes.Document"%>

<%@ page import="org.jsoup.nodes.Element"%>

<%@ page import="org.jsoup.select.Elements"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String string = ""; //string 선언
String link = "https://www.naver.com/"; //link받아오기
Document doc = Jsoup.connect(link).get(); //link 적용
Elements rowElements = doc.select("div.area_hotkeyword.PM_CL_realtimeKeyword_base > div.ah_list.PM_CL_realtimeKeyword_list_base > ul.ah_l > li.ah_item > a.ah_a > span.ah_k");
// 태그 선택하기
for(Element row : rowElements) // for 문 돌리기
{
	string += row.text() + "\n"; // row.text를 한 줄씩 끊음
}

%>

<%=string + "\n"%> 
</body>
</html>