<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedReader" %>
<%@page import="java.io.DataOutputStream" %>
<%@page import="java.io.InputStreamReader" %>
<%@page import="java.net.HttpURLConnection" %>
<%@page import="java.net.URL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!--  ------------------------------헤드 시작-------------------------------- -->

 <head>
  <meta charset="utf-8" />

  
</head>

<body >

<%

String clientId = "v05bZlQfeJ5_HKwzHAh8";//애플리케이션 클라이언트 아이디값";
String clientSecret = "ZYa6od5gqF";//애플리케이션 클라이언트 시크릿값";
try {
    String apiURL = "https://openapi.naver.com/v1/datalab/search";
    String body = "{\"startDate\":\"2019-01-01\",\"endDate\":\"2019-04-30\",\"timeUnit\":\"month\",\"keywordGroups\":[{\"groupName\":\"한글\",\"keywords\":[\"한글\",\"korean\"]},{\"groupName\":\"영어\",\"keywords\":[\"영어\",\"english\"]}],\"device\":\"pc\",\"ages\":[\"1\",\"2\"],\"gender\":\"f\"}";
    URL url = new URL(apiURL);
    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("X-Naver-Client-Id", clientId);
    con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
    con.setRequestProperty("Content-Type", "application/json");

    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(body);
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    BufferedReader br;
    if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
    } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
    }

    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = br.readLine()) != null) {
        response.append(inputLine);
    }
    br.close();
    System.out.println(response.toString());

} catch (Exception e) {
    System.out.println(e);
}

%>

</body>
</html>