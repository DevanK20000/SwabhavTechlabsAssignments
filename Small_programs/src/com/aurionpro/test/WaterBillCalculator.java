package com.aurionpro.test;

import java.util.Scanner;

public class WaterBillCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of units consumed: ");
		Integer units = scanner.nextInt();
		Integer charge = 0;
		Integer meter_charge = 75;
		if (units <= 100) {
			charge = units * 5;
		} else if (units <= 250) {
			charge = units*10;
		} else {
			charge =  units*20;
		}
		
		Integer total_water_bill = charge+meter_charge;
		System.out.println("Total Water Bill: " + total_water_bill);
		scanner.close();
	}
}
