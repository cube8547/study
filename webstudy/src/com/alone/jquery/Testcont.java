package com.alone.jquery;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Testcont {

	public static void main(String[] args) {
		List<EmpVO> returnList = new ArrayList<>();
	    
		EmpSVC svc = new EmpSVC();
		returnList = svc.process(request);
		/////SVC 서비스Controller를 통해 데이터를 조작 및 불러온다 /////
				
		String personJson="";
		String temp = "";
				
		PrintWriter out = response.getWriter();
				
		    /////불러온 데이터 리스트를 Json객체 형식으로 구현후 다시 클라이언트로 보냄 /////
			for(int i=0;i<returnList.size();i++){
				  temp +="{\"empNo\":"+returnList.get(i).getEmpNo()
					+",\"empName\":"+ "\"" + returnList.get(i).getEmpName() + "\""
					+",\"deptNo\":" + returnList.get(i).getDeptNo()
					+",\"empSal\":" + returnList.get(i).getSal();

					if(i==returnList.size()-1){
						temp += "}";
					}else{
						temp += "},";
					}
			}

			personJson = "[" + temp +"]";
			out.print(personJson);
			out.flush();

		System.out.println(personJson);



	}

}
