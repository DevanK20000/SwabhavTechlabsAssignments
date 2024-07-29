package com.aurionpro.test;

import java.util.Scanner;

public class MinuteToHoursConverter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter minutes:");
		int totalMinutes = scanner.nextInt();

		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;

		System.out.println(totalMinutes + " minutes = " + hours + " hours " + minutes + " minutes");
	}
}
