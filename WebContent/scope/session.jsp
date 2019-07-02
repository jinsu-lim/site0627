<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//클라이언트가 최초의 접속이라면 세션 객체가 생성되고, 고유한 id가 발급된다.
String id=session.getId();//tomcat이 현재 클라이언트에게 발급한 고유 session id.
//클라이언트의 브라우저에 쿠키로 기록.
out.print("당신이 발급받은 id는"+id);
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>