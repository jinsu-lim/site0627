<%@page import="shop.Member"%>
<%@page import="shop.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //브라우저를 닫지 않고 온 클라이언트라면 계속 해당 session을 참조할 수 있다. 따라서 우리가 담아 놓은 cart객체를 
    //꺼내서 사용할 수 있다.
    Cart cart=(Cart)session.getAttribute("cart");
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
</head>
<body bgcolor="green">
장바구니에 담겨진 상품은 <%=cart.getName() %>
갯수는 <%=cart.getEa() %>
가격은 <%=cart.getPrice() %>

</body>
</html>