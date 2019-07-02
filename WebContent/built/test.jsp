<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
jsp는 실행 직전에 서블릿 클래스로 변경된다.
그렇다면 jsp란 왜 제공되는 것일까?
-순수한 서블릿만을 이용하면 문서의 태그를 컨텐츠 내용 모두를 out.print("<html>"); 이런식으로 개발해야 한다.
따라서 디자인 영역에 너무 효율성이 떨어짐.

개발자는 jsp에서 지원되는 내장객체라 불리는 객체들이 서블릿으로 변경될 때 어떤 자료형인지 알고 있어야 한다.
예)request 객체의 자료형 : HttpServletRequest
   response 객체 : 응답정보를 보유한 객체 HttpServletResponse
   session 객체 : 클라이언트와 연결을 지속한 것처럼 효과를 내기위한 객체, HttpSession
   application 객체 : 웹어플리케이션 전역적 정보를 보유한 객체, ServletContext
   내장객체 중 request < session < application의 생명력을 이해
   누가 가장 오래 유지되나?
   
*/
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