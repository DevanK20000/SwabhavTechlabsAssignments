package com.aurionpro.model;

public class GameBoard implements IGameBoard {
	private int size;
	private char[][] board;

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		this.size = size;
		this.board = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = ' ';
			}
		}
	}

	@Override
	public void makeMove(int row, int col, char player) {
		// TODO Auto-generated method stub
		board[row][col] = player;

	}

	@Override
	public char[][] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j]);
				if (j < size - 1) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < size - 1) {
				System.out.println(new String(new char[size * 4 - 1]).replace("\0", "-"));
			}

		}
	}

}
