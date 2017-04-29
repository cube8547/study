package com.alone.json;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JsonTest_01 {
	
	
	static Logger logger = Logger.getLogger(JsonTest_01.class);//클래스명 아래에 사용
	
	
	public static void main(String[] args) {
PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		//------------ JSON으로 테이터 입력
		
		JSONObject obj = new JSONObject();
		
		
		obj.put("key1", "value1");
		obj.put("key2", "value2");			
		
		//--------------JSONObject으로 받은 데이터 JSON형태로 뿌려주기
		
		JSONObject jsonObj = (JSONObject) JSONValue.parse("value");
		
		String tmp;
		tmp = (String) obj.get("key2"); //value2의 값이 들어온다
		//System.out.println(tmp);
		logger.debug(tmp);

	}

}
