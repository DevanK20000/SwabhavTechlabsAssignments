package com.aurionpro.test;

import java.util.Scanner;

public class BMICalculator {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Please enter your weight in kilograms:");
	        Double weight = scanner.nextDouble();

	        System.out.print("Please enter your height in meters:");
	        Double height = scanner.nextDouble();

	        double bmi = weight / (height * height);

	        System.out.println("BMI is: "+ bmi);

	    }
}
