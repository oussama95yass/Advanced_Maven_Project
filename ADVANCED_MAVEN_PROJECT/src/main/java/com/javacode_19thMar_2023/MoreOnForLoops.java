package com.javacode_19thMar_2023;

public class MoreOnForLoops {

	public static void main(String[] args) {
		//nested for loop
		   //for loop inside for loop
		
		for(int i=1; i<=2 ;i++) { //outer for loop represents Rows
			
			for(int j=1; j<=2; j++) { //inner for loop represents Cols
				//body of the inner for loop
				System.out.println("Hello");
			}
			System.out.println("Row");
			//this is the body of the outer for loop
		}

	}

}
