<%@page import="shop.Member"%>
<%@ page import="shop.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
  request.setCharacterEncoding("utf-8");
 
  String name=request.getParameter("name");
  String ea=request.getParameter("ea");
  String price=request.getParameter("price");
  //낱개로 된 데이터를 하나의 인스턴스에 몰아넣자
  Cart cart=new Cart();
  cart.setName(name);
  cart.setEa(Integer.parseInt(ea));
  cart.setPrice(Integer.parseInt(price));
  
  //현재 클라이언트가 사용가능한 세션에 cart를 담는다.
  session.setAttribute("cart", cart);
  
  
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
<body bgcolor="yellow">
당신이 입력한 상품은 <%=cart.getName() %>
갯수는 <%=cart.getEa() %><br>
가격은 <%=cart.getPrice() %><br>
<p>
<a href="c.jsp">장바구니 담기</a>

</body>
</html>