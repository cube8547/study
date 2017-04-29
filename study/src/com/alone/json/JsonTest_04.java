package com.alone.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest_04 {

	public static void main(String[] args) {
		  //Json 객체 생성.
        JSONObject jobj = new JSONObject();
        jobj.put("name", "wdkang");
        jobj.put("company", "acanet");
        jobj.put("age", "26");
       
        //Json Array 생성.
        JSONArray maglist = new JSONArray();
        maglist.add("JSON test");
        maglist.add("hello JSON");

        jobj.put("list", maglist);

        try {

               FileWriter file = new FileWriter("c:\\myJson.json");
               file.write(jobj.toJSONString());
               file.flush();
               file.close();
        } catch(IOException e) {
               e.printStackTrace();
        }
        System.out.println("Create JSON Object : "+jobj);


//이렇게해서 생성된 myJson.json 파일은 다음과같은 문자열을 가지게 됩니다. 자바스크립트의 Object객체와 같은 형식입니다. 
//그렇기에 자바스크립트의 eval()를 이용하여 바로 자바스크립트 객체로 사용할수가 있게됩니다.
//그럼 이 생성된 json파일을 웹프로젝트같은 경우면 request에 담아 뿌려주면 되는거고
//(이때는 파일이 아닌 객체상태로 request에 담아야겠죠?), 지금은 자바프로젝트로 진행했으니 파일을 읽어와 다시 파싱해서 콘솔에 뿌리는걸로 하겠습니다.




	}

}
