<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID값 전송</title>
</head>
<body>

<!-- 
¤ JSP 소스만들기
 
▼ 이제 JSP 페이지 소스를 간단하게 만들어 보겠습니다. 
input 박스를 하나 만들어서 값을 입력하고 전송하게 되면 Servlet 에서 받게 되는 것입니다. 
클라이언트에서 전송방식은 POST 로 합니다. 그럼 Servlet 에서는 doPost() 함수에서 받을 수 있겠죠.


 -->
<form method="post" action="/WebApp/login">
ID : <input type="text" name="name">
<input type="submit" value="전송">














</body>
</html>