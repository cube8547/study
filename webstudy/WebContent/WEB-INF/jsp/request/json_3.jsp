<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    
    
    
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON 파싱</title>

  <style> </style>
  
  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  
  <script>
  
  //$(function(){})의 기능은 body의 구조를 파악하자 마자
     $(function(){
    $.ajax({
     url: "data.json",
     dataType: "json",
     success: function(data){
      //json의 경우는 data는 파싱된 결과
      //alert(data[0].num);
      $.each(data, function(index, item){
       alert(item.key + ":" +item.value);
       
       //객체를 가져다가 파싱
       //var ar=data["fields"];
       //var ar1=data["records"];
       //alert(ar[0].id+ar1[0].재산구분)
      })
      
     }
    })
   })
  </script>




</head>
<body>

</body>
</html>