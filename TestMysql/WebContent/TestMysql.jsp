<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 작성일 : 2015 - 02 - 19<br/>
 TEST - MySQL 데이터베이스 호출 테스트 <br/>
 mysql-connector-java 사용<br/>
 
<div>
	<form method="post" action="jdbc.do?cmd=showDatabaseList">
		
		<input type="submit" value="getjdbc"/>
	</form>
</div>
<div>
	<form method="post" action="jdbc.do?cmd=select_table1">
		
		<input type="submit" value="select_table1"/>
	</form>
</div>

</body>
</html>