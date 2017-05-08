package com.alone.beginning;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

//원하는 단수를 입력해서 구구단을 만들고 JSON으로 출력
//JSON은 정렬이 안되기 때문에 
//logger 사용 방법 PJT에 HttpDriver를 추가하고 사용 할 pjt -> lib -> log4j를 등록 -> properties등록 -> 꼭 빌드 패스할 것 총 2번
//팁 : F5누르면 콘솔창에 뜬 로그 나오는 폴더 만들어짐(현재까지의 모든 로그가 나옴)

public class Day1 {
	static Logger logger = Logger.getLogger(Day1.class);//클래스명 아래에 사용
	
	public static void main(String[] args) throws ParseException {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		 //Json 객체 생성.
        JSONObject jobj = new JSONObject(); // 제이슨 객체 생성

		
		//JSONObject jsonObject = (JSONObject) JSONParser.parse();
		Scanner scan = new Scanner(System.in); // 문자 입력 준비 
		//logger.debug("단을 입력하세요");
		
		int dan = scan.nextInt(); // 키보드 문자 입력
		
		
		if(dan > 1){
		for(int i=1; i<=9; i++)
		

			
			
		//제이슨으로 출력
		jobj.put(dan+"*1", dan * 1);
		jobj.put(dan+"*2", dan * 2);
		jobj.put(dan+"*3", dan * 3);
		jobj.put(dan+"*4", dan * 4);
		jobj.put(dan+"*5", dan * 5);
		jobj.put(dan+"*6", dan * 6);
		jobj.put(dan+"*7", dan * 7);
		jobj.put(dan+"*8", dan * 8);
		jobj.put(dan+"*9", dan * 9);
		
        JSONArray jArray = new JSONArray(); // 제이슨 정렬 객체 생성
		
       // jArray.add(jobj);
        
        String jArra = jArray.toString();
        
		String josnst = jobj.toString();
		
		jArray.add(jobj);
		
		//logger.debug(josnst);
		//logger.debug(jobj);
		
		}else{
			logger.debug("Error!!!");
		}
		//josnst = jArray.toString();
		
		//logger.debug(jArra);
		
		
		
		

		
		
	
		
		

	}

}
