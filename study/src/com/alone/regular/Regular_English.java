package com.alone.regular;

import java.util.regex.Pattern;

public class Regular_English {

	public static void main(String[] args) {
		String pattern = "^[a-zA-Z]*$";
        String input = "ABzzzDAWRAWR";
        
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
^[a-zA-Z]*$
a-z 까지 그리고 A-Z 까지 즉, 알파벳은 모두 허용.
* 글자 수 상관하지 않음
-> 알파벳이기만 하면 패턴에 맞음.


*/
