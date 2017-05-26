package com.alone.regular;

import java.util.Scanner;
import java.util.regex.Matcher; //정규표현식을 사용하기 위해 import해줍니다. 
import java.util.regex.Pattern;

public class Regular_Number {

	public static void main(String[] args) {
	//숫자만 허용
		
		Pattern p = Pattern.compile("(^[0-9]*$)"); // 숫자만 허용하는 Pattern p 입니다.
        
        int onlyNum;
        String inputVal;
        Scanner iStream = new Scanner(System.in);
        System.out.print("숫자를 입력 : ");
        
        inputVal = iStream.nextLine();
        Matcher m = p.matcher(inputVal); //inputVal의 값이 저희가 선언한 패턴 p 에 맞는 조건인지 검사해서 m에 저장합니다.
        
        
        if(m.find()) //m.find() 는 패턴이 일치하는경우 boolean 형으로 true를 아니면 false를 리턴합니다.
        {
            onlyNum = Integer.parseInt(inputVal); //inputVal을 int형으로 형변환 해줍니다.
            System.out.println(onlyNum);
        }
        else
        {
            System.out.println("숫자가 아닌데..?");
        }    
	}

}


/*
표현식

 설명 

 ^ 문자열의 시작

$  문자열의 종료

 . 임의의 한 문자 (문자의 종류 가리지 않음) 단, \ 는 넣을 수 없음

 * 앞 문자가 없을 수도 무한정 많을 수도 있음

+  앞 문자가 하나 이상
?  앞 문자가 없거나 하나있음
 [] 문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타낸다. []내에서 ^가 선행하여 존재하면 not 을 나타낸다.

 {} 횟수 또는 범위를 나타낸다.
 () 소괄호 안의 문자를 하나의 문자로 인식 

 | 패턴 안에서 or 연산을 수행할 때 사용
  \s 공백 문자

 \S 공백 문자가 아닌 나머지 문자

 \w 알파벳이나 숫자
\W  알파벳이나 숫자를 제외한 문자
\d  숫자 [0-9]와 동일
\D  숫자를 제외한 모든 문자
\  정규표현식 역슬래시(\)는 확장 문자
 역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미
(?i)  앞 부분에 (?i) 라는 옵션을 넣어주면 대소문자를 구분하지 않음

예제의 ^[0-9]*$ 를 분석해보면 
^ 으로 우선 패턴의 시작을 알립니다.
[0-9] 괄호사이에 두 숫자를 넣어 범위를 지정해줄 수 있습니다.
* 를 넣으면 글자 수를 상관하지 않고 검사합니다.
$ 으로 패턴의 종료를 알립니다.


[자주 쓰이는 패턴]
1) 숫자만 : ^[0-9]*$
2) 영문자만 : ^[a-zA-Z]*$
3) 한글만 : ^[가-힣]*$
4) 영어 & 숫자만 : ^[a-zA-Z0-9]*$
5) E-Mail : ^[a-zA-Z0-9]+@[a-zA-Z0-9]+$
6) 휴대폰 : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
7) 일반전화 : ^\d{2.3} - \d{3,4} - \d{4}$
8) 주민등록번호 : \d{6} \- [1-4]\d{6}
9) IP 주소 : ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3})




*/
