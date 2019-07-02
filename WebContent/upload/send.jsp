<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>
<script>
addEventListener("load",function(){//문서가 로드되면
	document.querySelector("button").addEventListener("click", function(){
		upload();
	});
});
//서버측에 파일 업로드 요청
function upload(){
	form1.encoding="multipart/form-data";//form 태그의 속성에서는 enctype임을 주의!!
	form1.action="/upload/regist.jsp";//전송 url
	form1.method="post";
	form1.submit();
}
</script>
</head>
<body>
  <form name="form1">
   <input type="text" placeholder="파일제목" name="title"/>
   <br>
   <input type="file" name="myfile">
  </form>
  <button>업로드 실행</button>
</body>
</html>