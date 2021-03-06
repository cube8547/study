package com.alone.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest_03 {

	
	//JSON문자열을 OBJECT로 생성하는 코드
	
	static Logger logger = Logger.getLogger(JsonTest_02.class);//클래스명 아래에 사용
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		

		//최상단 json객체
		JSONObject jsonroot=new JSONObject();
		//가상의 list객체 (db에서 조회한 결과라고 가정)
		ArrayList<Map<String,Object>> selectlist=new ArrayList<Map<String,Object>>();
		Map<String,Object> dbmap=null;
		for(int i=0;i<20;i++){
		    dbmap=new HashMap<String,Object>();
		    dbmap.put("data", "가상의DB데이터"+i);
		    selectlist.add(dbmap);
		    //logger.debug(dbmap);
		}
		//json 배열목록을 담아줄 jsonarray 객체생성
		JSONArray jsonList=new JSONArray();
		//가상DB목록을 JSON배열목록에 출력하기 위한 임의의 JSON오브젝트
		JSONObject jsontmp=null;
		//DB에서 조회한 값을 반복문을 이용하여 객체 하나씩 뽑아온다
		for(Map<String,Object> selectone : selectlist){
		    Set<String> key=selectone.keySet();
		    //MAP의 KEY/VALUE를 통하여 JSON임시객체에 담아준후
		    for (Iterator<String> iterator=key.iterator();iterator.hasNext();){
		        String tmpekey=(String) iterator.next();
		        String tmpvalue=(String) selectone.get(tmpekey);
		        jsontmp=new JSONObject();
		        jsontmp.put(tmpekey, tmpvalue);
		       // logger.debug(tmpekey + tmpvalue);
		    }
		    //JSON배열목록에 추가
		    jsonList.add(jsontmp);
		}
		//db목록 json set
		jsonroot.put("result",jsonList);
		/*//성공여부
		jsonroot.put("success",true);
		PrintWriter pw=response.getWriter();
		pw.print(jsonroot);
		pw.flush();
		pw.close();*/


		
		
		
	}

}
