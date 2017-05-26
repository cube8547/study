package com.alone.regular;

public class Regular_Kor {

	public static void main(String[] args) {
		String strText = "aaa한글 테스트aaa";
		if(strText.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			System.out.println("한글포함");
		}

	}

}
