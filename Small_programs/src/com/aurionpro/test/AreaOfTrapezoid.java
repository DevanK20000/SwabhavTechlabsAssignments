package com.aurionpro.test;

import java.util.Scanner;

public class AreaOfTrapezoid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter base: ");
		Double base = scanner.nextDouble();
		System.out.print("Enter second base: ");
		Double base2 = scanner.nextDouble();
		System.out.print("Enter height: ");
		Double height= scanner.nextDouble();
		
		Double area = ((base+base2)/2)*height;
		
		System.out.println("Area of trapezoid: "+area);
	}
}
