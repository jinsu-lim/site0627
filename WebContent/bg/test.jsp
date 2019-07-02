<%@ page contentType="text/html; charset=UTF-8"%>
<%
   String bg=request.getParameter("bg");
   if(bg==null){
      bg="yellow";
   }
%>
<!DOCTYPE html>
<html>
<head>
<script>
   function setBg(){
      form1.action="test.jsp";
      form1.submit();
   }
   
</script>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="<%=bg%>">
   <form name="form1">
   <select name="bg">
      <option value="red">빨개ㅗㅜㅑ</option>
      <option value="blue">파래ㅗㅜㅑ</option>
      <option value="green">초록촐롥ㅗㅜㅑ</option>
      <option value="pink">삥꾸ㅗㅜㅑ</option>
   </select>
   <button type="button" onclick="setBg()">색상 변경</button>
   </form>
</body>
</html>