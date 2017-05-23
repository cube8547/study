<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style>
		ul#menu li {
		    background-color: black;
		    color: white;
		    padding: 5px 10px;
		    text-decoration: none;
		    border-radius: 4px;
		    margin-bottom: 5px;
		    width: 100px;
		}
		
		ul#menu li:hover {
		    background-color: orange;
		}
		
		table {
			border: 1px solid black;
		}
		
		table#div_getData td {
			width: 100px;
			padding: 10px;
			border: 1px solid black;
		}
	</style>
<script type="text/javascript" src="jquery-2.2.2.min.js"></script>

<script>
		$(function(){

			$('#menu li').hover(function() {
				var getDeptNo="";
				var htmlText="";
				getDeptNo = $(this).text();
				
				$(this).append($("<span> ***</span>"));
				
				$.ajax({
					type : "post",
					url : "Testcont",
					data : { deptNo: getDeptNo},
					dataType : "json",

					success : function(data) {
						for(var i =0;i<data.length;i++){
							htmlText +="<tr>"
							+"<td>"+ data[i].empNo +"</td>"
							+"<td>"+ data[i].empName +"</td>"
							+"<td>"+ data[i].deptNo +"</td>"
							+"<td>"+ data[i].empSal+"</td>"
							+"</tr>"
						}
						$('table > tbody').html(htmlText);
					},
					complete : function(data) {

					},
					error : function(xhr, status, error) {
						console.log("에러!: " + error);
					},
				});
			}, function() {
				$(this).find("span:last").remove();
			});
		});
	</script>

</head>
<body>

<div>
		<h2>사원정보를 검색하세요!</h2>
		<ul id="menu" style="list-style-type:square">
			<li>1000</li>
			<li>2000</li>
			<li>3000</li>
			<li>4000</li>
		</ul>
	</div>
	
	<table id="div_getData">
		<thead>
			<tr>
				<td>사번</td>
				<td>이름</td>
				<td>부서</td>
				<td>월급</td>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</div>




</body>
</html>