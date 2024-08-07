package com.aurionpro.model;

import java.util.Scanner;

import com.aurionpro.exception.CellAlreadyMarkedException;
import com.aurionpro.exception.InvalidLocationException;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Player currentPlayer;
	Player[] players = new Player[2];
	Board board;
	ResultAnalyzer resultAnalyzer;
	ResultType result = ResultType.PROGRESS;

	String player1, player2;
	int size;

	public Game(String player1, String player2, int size) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.size = size;
	}

	private void initialize() {
		// initialize players
		players[0] = new Player(player1, MarkType.X);
		players[1] = new Player(player2, MarkType.O);

		// initialize board;
		board = new Board(size);

		// initialize results analyzer
		resultAnalyzer = new ResultAnalyzer(board, result);

		// initialize current player
		currentPlayer = players[0];
	}

	public void playGame() {
		initialize();
		while (result == ResultType.PROGRESS) {
			try {
				board.printBoard();
//				while (!moveMade) {
					System.out.println("Player " + currentPlayer.getPlayerName() + ", enter your move (row [1-"
							+ board.getSize() + "] and column [1-" + board.getSize() + "]):");
					int row = scanner.nextInt() - 1;
					int col = scanner.nextInt() - 1;
					
					if((row >= size) || (col >=size))
						throw new InvalidLocationException();						
					
					board.setCellMark(row, col, currentPlayer.getMark());
					result = resultAnalyzer.anlyzeResult();
					switch (result) {
					case DRAW:
						System.out.println("The game is a draw!");
						break;
					case WIN:
						System.out.println(
								"Player " + currentPlayer.getPlayerName() + " " + currentPlayer.getMark() + " wins!");
					default:
						break;
					}
					
					currentPlayer = (currentPlayer.equals(players[0]))? players[1] : players[0];

//				}

			} catch (CellAlreadyMarkedException e) {
				// TODO: handle exception
				System.err.println("This slot is already filled. Please choose another slot.");
			}
			catch (InvalidLocationException e) {
				// TODO: handle exception
				System.err.println("Invalid coordinates.");
			}
		}
	}
}
