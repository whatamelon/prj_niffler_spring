<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!--  ------------------------------헤드 시작-------------------------------- -->

 <head>
  <title>
   로그아웃
  </title>
  
</head>

<body>
 <%
        session.invalidate(); // 모든세션정보 삭제
        response.sendRedirect("../user/intro.do"); // 인트로 화면으로 다시 돌아간다.
    %>
</body>
</html>