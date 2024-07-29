package com.aurionpro.test;

import java.util.Scanner;

public class TreasureHunt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String direction;

		System.out.println("Welcome to Treasure island\nYour mission is to find the treasure.");
		System.out.println("Left or Right? (use 'L' or 'R')");
		direction = scanner.nextLine();
		if (direction != "L" || direction != "l") {
			System.out.println("Fell into the hole.\nGame Over");
			return;
		}
		System.out.println("Swime or wait? (use 'S' or 'W)");
		direction = scanner.nextLine();
		if (direction != "W" || direction != "w") {
			System.out.println("Attacked by the trout.\nGame Over");
			return;
		}

		System.out.println("Which door?\nRed (use 'R)\nBlue (use 'B')\nYellow (use 'Y')");
		direction = scanner.nextLine();
		if (direction == "Y" || direction == "y") {
			System.out.println("You Win");
			return;
		}
		else if (direction == "B" || direction == "b")
			System.out.println("Eaten by beast.");
		else if (direction == "R" || direction == "r")
			System.out.println("Burned by fire.");

		System.out.println("Game Over");

	}
}
