package com.alone.json_1;

import javax.servlet.http.HttpServletRequest;


/*
Web Application 개발시 Ajax 로 서버와 통신하며 데이터를 주고 받는데, 그때
데이터 조작을 좀더 쉽게 하기 위해서 JSON 프로토콜을 사용하게 된다. 소규모
사이트에서 API 서비스를 할 때 사용해도 좋은 기술인 것 같다.

 (1) JSON 이란 ?
 그럼 JSON 은 어떤 형태로 데이터를 주고 받는것일까? JSON(JavaScript Object Notation) 은
약자에서도 나와있듯이 자바스크립트 표준인 ECMA-262 3판 객체문법에 기초를 해
작성되었으며 유니코드를 기본 인코더로 사용한다. 주고 받을수 있는 자료형은 숫자, 문자열
boolean, 배열, 객체 이다.
기본 데이터 배열은 이름/값 쌍의 집합으로 구성되어있으며 중괄호로 싼다. key 값이
문자열이기 때문에 반드시 따옴표를 하고 값은 기본자료형이나 배열, 객체를 넣으면 된다.
각 쌍의 순서는 의미가 없다.
{"name2": 50, "name3": "값3", "name1": true}  기본 표현 형태이며 아래는 배열까지 포함된
한사람의 구체적인 인적 정보를 나타낸 예제이다.
 
{
    "이름": "테스트",
    "나이": 30,
    "성별": "남",
    "기혼": true,
    "주소": "서울특별시 양천구 목동",
"가족관계": {"#": 2, "동생": "홍길동", "어머니": "뺑덕"}
    "회사": "부산시 북구 구포동"
 }


(2) Java 환경에서의 json 구현

JSON 을 많이 쓰게 되는 이유느느 프로그래밍 언어와 플랫폼에 독립적으로 구현이 가능하며
서로 다른 시스템간에 객체를 교환하기 좋기 때문이다. 그리고 자바스크립트 문법을
채용했기 때문에 웹환경에서 개발이 유리하다.
 
이제 구현이 남았다. 구현을 할려면 json 으로 인코더 할수 있도록 라이브러리가 필요한데
언어별로 그런 라이브러리 클래스와 샘플을 제공하는곳이 있다.
http://json.org/  이 그곳이다. 리스트에 보면 C#, Java, ASP 등등 흔히 접하는 언어들이 있다.


그림확인 

여기에서 jsp와 Ajax 의 간단한 샘플을 소개하고자 한다. 이것을 조금만 변형하면
서블릿에서 사용이 가능하다. 나는 java 관련 모듈을 구현할 것이므로 java 리스트에
json-sample 를 클릭해 들어간다. 그러면 구글 코드 사이트로 가게 되는데
중간쯤에 json_simple-1.1.jar 를 다운받는다. json 데이터 포맷을 위한 라이브러리이다.








*/
public class JsonTest {

	public static void main(String[] args) {
		
		public ModelAndView data(HttpServletRequest request,
		        HttpServletResponse response) throws Exception{
		        
		    PrintWriter out = response.getWriter();
		        
		    JSONObject obj = new JSONObject();
		    obj.put("name","foo");
		    obj.put("num",new Integer(100));
		    obj.put("balance",new Double(1000.21));
		    obj.put("is_vip",new Boolean(true));
		    obj.put("nickname",null);
		    out.print(obj);
		    out.flush();
		    out.close();   
		     
		    return null;   
		}


		

	}

}
