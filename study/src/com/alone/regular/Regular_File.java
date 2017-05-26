package com.alone.regular;

import java.util.regex.Pattern;

public class Regular_File {

	public static void main(String[] args) {
		String pattern = "^\\S+.(?i)(txt|pdf|hwp|xls)$";
        String input = "abc.txt";
        
        
        
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
패턴분석



^\\S+.(?i)(txt|pdf|hwp|xls)$

^ : 시작
\ : \ 가 왔기 때문에 다음에 올 문자는 특수문자로 취급하고 , \다음 특수문자고 오면 그 자체로 취급.
\S : 공백 아닌 문자
+. : .이 반드시 한개는 와야한다.
(?i) : 대소문자 구별하지 않음.
(txt|pdf|hwp|xls) : txt 혹은 pdf 혹은 hwp 혹은 xls 만 허용. | 을 이용한 or 연산!
$ : 끝

-> 공백아닌 문자와 .이 반드시 와야하고 뒤에는 txt, pdf, hwp, xls 만 허용.


*/

