package com.alone.beginning;

import java.util.Scanner;

// *로 삼각형 만들기, 여러가지로


public class Day7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//*****
		//****
		//***
		//**
		//*
		/*System.out.println("정수를 입력하세요");
		int n = sc.nextInt();
		int line = 0;
		
		for (line = 1; line <= n; line++) {
			for (int j = n; j >= line; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}*/
		
		//오른쪽 공백 삼각형
		for(int i=1; i<=5;i++){
			for(int j=1; j<=i; j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------------------------------");
		//오른쪽 공백 반대 삼각형
		for(int i=5; i>=1; i--){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------------------------------");
		
		//왼쪽 공백 삼각형
		
		for(int i=1; i<=5; i++){
			for(int j=5; j>i; j--){
				System.out.print(" ");
			}
			for(int k=1; k<=i;k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------------------------------");
		
		//왼쪽 공백 반대 삼각형
		
		for(int i=0; i<5; i++){
			for(int j=0; j<i; j++){
				System.out.print(" ");
			}
		for(int k=5-1; k>0; k--){
			System.out.print("*");
		}
		System.out.println("");
		}
		
		System.out.println("--------------------------------");
		
		
		
		
		
		
		
		
		
		

	}

}
