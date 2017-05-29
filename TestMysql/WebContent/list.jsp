<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<body>
<h2>MySQL database list</h2>

<table border = "1" width = "300">
	<tr>
		<td>NO</td>
		<td>Databases</td>
	</tr>
	<c:forEach var="list" items="${requestScope.databaselist}" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${list }</td>
		</tr>	
	</c:forEach>
</table>


</body>
</html>