package com.aurionpro.test;

import java.util.Scanner;

public class CompoundIntreast {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter principal amount: ");
		Double principal = scanner.nextDouble();

		System.out.print("Enter interest rate (annually in percentage): ");
		Double rateOfInterest = scanner.nextDouble();

		System.out.print("Enter how many time in years: ");
		Double timeInYears = scanner.nextDouble();

		Double compoundInterest = (principal * Math.pow(1 + rateOfInterest/100, timeInYears)) - principal;

		System.out.println("Compound Interest after "+timeInYears+" is "+compoundInterest);
	}
}
