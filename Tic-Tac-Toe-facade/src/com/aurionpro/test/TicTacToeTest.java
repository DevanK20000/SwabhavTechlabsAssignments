package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.TikTacToe;

public class TicTacToeTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the game board:");
        int size = scanner.nextInt();
        TikTacToe game = new TikTacToe(size);
        game.playGame();
        scanner.close();
        //
    }
}
