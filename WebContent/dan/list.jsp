<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//클라이언트가 전송한 dan 변수 받기
  String dan=request.getParameter("dan");
  if(dan==null){
	  dan="2";
  }
  out.print("넘겨받은  dan은"+dan);
%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
window.addEventListener("load", function(){
	var sel=document.querySelector("select");
	
	sel.addEventListener("change",function(){
		if(this.value!="0"){
			send();
		}else{
			alert("단을 선택하세요");
		}
	});
});

function send(){
	var form=document.querySelector("form");
	form.action="list.jsp";
	form.method="get";
	form.submit();
}
</script>

</head>
<body>
<form>
<select name="dan">
 <option>단 선택</option>
 <%for(int i=2;i<=9;i++){ %>
  <option <%if(i==Integer.parseInt(dan)){%>selected<%}%> value="<%=i %>"><%=i %>단 선택</option>
  <%} %>
</select>
</form>
<p>
<%
for(int i=1;i<=9;i++){
	out.print(dan+"*"+i+"="+(Integer.parseInt(dan)*+i)+"<br>");  
}
%>

</body>
</html>