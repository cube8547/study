<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="hp" value="" >
	<input type="button" id="btn" onclick="javascript:check(); " value="버튼">
	<script type="text/javascript">
		function check() {
			var hp = document.getElementById("hp").value ;
			
			var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
			
			
			if ( !regExp.test( hp ) ) {
			      alert("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
			      return false;
			}else {
				alert(hp);
			}
			
		}
	</script>
</body>
</html>