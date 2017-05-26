package com.alone.regular;

import java.util.regex.Pattern;

public class Regular_Email {

	public static void main(String[] args) {
		String [] mails = {"okjsp@okjsp.pe.kr",
                "@okjsp.pe.kr",
                "hello@kr",
                "happ_okjsp.pe.kr"};
                 
	for(int i=0; i<mails.length; i++) {
	System.out.println(mails[i] + " : " + isEmail(mails[i]));
	} // end for
	}
	/**
	 * Comment  : 배열에서 정상적인 이메일 인지 검증.
	 */
	    public static boolean isEmail(String email) {
	        if (email==null) return false;
	        boolean b = Pattern.matches(
	            "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", 
	            email.trim());
	        return b;
	}

	

}
