<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSPjQuery_1</title>

<!-- 
1. JSP의 insert_action()에서 입력된 데이터를 JSON 형식으로 변환.
2. JSON 형식으로 변환 한 데이터를 ajax를 사용하여 해당 URL로 전송
3. 결과값을 request.done로 Object 형식으로 전송, 내용은 JSON 형식으로 받도록 설정
    예제값 : {"error":2}
4. 결과값에 대한 처리
5. request.fail은 해당 URL로 값 전송 오류 시 처리하는 부분
☞주의사항 : jquery.js를 등록 해줘야 함.

 -->
<!-- Ajax 사용을 위한 jquery -->
 <script src="//code.jquery.com/jquery.js"></script>
 
 <!-- JavaScript -->
 <script type="text/javascript">
  function insert_action(){
   var mForm = document.insert; // form의 값을 가져오기 위함
   var obj = new Object(); // JSON형식으로 변환 할 오브젝트
   obj.user_id = mForm.user_id.value; // form의 값을 오브젝트에 저장
   obj.user_password = mForm.user_password.value;
    
   var json_data = JSON.stringify(obj); // form의 값을 넣은 오브젝트를 JSON형식으로 변환
    
   var request = $.ajax({
    url:"값을 전송할 URL",
    type:"POST",
    data:json_data, // {“user_id”:”입력값”, “user_password”:”입력값”} 형식으로 전달 됨
    dataType:"json"
   });
   request.done(function(data){ // 전송 후, 결과 값 받아오는 부분
    if (data != null){
     if (data.error == 2) { // 임의 값 JSON 형식의 {“error”:2} 값을 서버에서 전달
                                                                         // data 오브젝트에 error의 값이 2일 때의 이벤트 처리
      alert("이미 등록되어 있는 아이디 입니다.");
     } else if (data.submit == true) {
      alert("등록 완료! 로그인 하시기 바랍니다.");
     }
    }
   });
   request.fail(function(jqXHR, textStatus){ // 에러 발생
    alert("등록 오류 발생!");
   });
  }
 </script>



</head>
<body>

<form name="insert" method="post" action=" ">
  <input type="text" name="user_id" id="user_id" placeholder="아이디를 입력해 주세요." >
  <input type="password" name="user_password" id="user_password" placeholder="비밀번호를 입력해 주세요." >
  <button type="button" onclick="insert_action()">등록</button>
 </form>



</body>
</html>