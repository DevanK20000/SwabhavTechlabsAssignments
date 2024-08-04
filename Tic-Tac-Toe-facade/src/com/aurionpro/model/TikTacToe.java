package com.aurionpro.model;

import java.util.Scanner;

public class TikTacToe {
	private IGameBoard board;
	private IGameRules rules = new GameRules();
	private Scanner scanner = new Scanner(System.in);

	public TikTacToe(int size) {
	        this.board = new GameBoard();
	        this.board.setSize(size);
	}

	public void playGame() {
		char currentPlayer = 'X';
		while (true) {
			board.printBoard();
			boolean moveMade = false;
            while (!moveMade) {
                System.out.println("Player " + currentPlayer + ", enter your move (row [1-" + board.getBoard().length + "] and column [1-" + board.getBoard().length + "]):");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (board.getBoard()[row][col] == ' ') {
                    board.makeMove(row, col, currentPlayer);
                    moveMade = true;
                } else {
                    System.err.println("This slot is already filled. Please choose another slot.");
                }
            }
			if (rules.checkWin(board)) {
				System.out.println("Player " + currentPlayer + " wins!");
				break;
			} else if (rules.checkDraw(board)) {
				System.out.println("The game is a draw!");
				break;
			}
			currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		}
		board.printBoard();
	}
}
