<%@page import="shop.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//정보를 담고 유지할 수 있는 객체는?
//request < session < application
%>    
<%
  Member member=(Member)session.getAttribute("member");
%>
<%=member.getUname() %>님 로그인 중
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
 function send(){
	 var form=document.querySelector("form");
	 form.action="b.jsp";
	 form.method="post";
	 form.submit();
	 
 }
</script>
</head>
<body>
  <form name="form">
  <input type="text" name="name" placeholder="제품명"/>
  <input type="text" name="ea" placeholder="갯수"/>
  <input type="text" name="price" placeholder="가격"/>
  </form>
  <button onClick="send()">전송</button>

</body>
</html>