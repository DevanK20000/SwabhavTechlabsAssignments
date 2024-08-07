package com.aurionpro.demo;

import java.util.Scanner;

import com.aurionpro.model.Game;

public class tictactoedemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first player name:");
        String player1 = scanner.nextLine();
        System.out.print("Enter the Second player name:");
        String player2 = scanner.nextLine();
        System.out.print("Enter the size of the game board:");
        int size = scanner.nextInt();
        
        Game game = new Game(player1, player2, size);
        game.playGame();
	}
}
