package com.aurionpro.model;

import java.util.Random;
import java.util.Scanner;


public class Pig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no_of_turns =0;
		System.out.println("--------Welcome to PIG !-------- ");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int turn_score=0;
		int total_score =0;
		rollDie(no_of_turns, scanner, random, turn_score, total_score);
	}

	private static void rollDie(int no_of_turns, Scanner scanner, Random random, int turn_score, int total_score) {
		while(true) {
			System.out.println("Roll or hold? (r/h): ");
			char choice = scanner.next().charAt(0);
			if(choice == 'h') {
				total_score+=turn_score;
				System.out.println("Score for turn: "+turn_score);
				System.out.println("Total score: "+total_score);
				turn_score=0;
				no_of_turns++;
				if(total_score>=20) {
					System.out.println();
					System.out.println("You finished in "+no_of_turns);
					break;
				}
				continue;

			}
			int roll = random.nextInt(6)+1;
			System.out.println("Die: " + roll);
			if(roll==1) {
				turn_score=0;
				System.out.println("Turn over. No score.");
				no_of_turns++;
				continue;
			}		
			turn_score+=roll;	
			
		}
	}

}
