package com.alone.regular;

import java.util.regex.Pattern;

public class Regular_File_1n2 {

	public static void main(String[] args) {
		 String pattern = "^\\S+.(?i)(txt|pdf|hwp|xls)$";
	        String input = "Java.pdf";
	        
	        String pattern2 = "(.+?)((\\.tar)?\\.gz)$";
	        String input2 = "library.tar.gz";
	        
	        vaildPattern(pattern, input);
	        vaildPattern(pattern2, input2);    
	    } 
	    
	    public static void vaildPattern(String pattern, String input)
	    {
	        boolean i = Pattern.matches(pattern, input);
	        
	        if(i==true)
	        {
	            System.out.println(input+"는 패턴에 일치함.");
	        }
	        else
	        {
	            System.out.println("패턴 일치하지 않음.");
	        }

	}

}

/*
새로 이중 확장자를 구분하는 표현식을 추가했습니다. 여기서는 tar.gz 인지 구분합니다. 한번 테스트 해보세요
*/