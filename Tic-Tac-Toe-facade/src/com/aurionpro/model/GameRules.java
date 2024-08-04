package com.aurionpro.model;

public class GameRules implements IGameRules {

	@Override
	public boolean checkWin(IGameBoard board) {
		// TODO Auto-generated method stub
		char[][] b = board.getBoard();
		int size = b.length;
		// Check rows and columns
		for (int i = 0; i < size; i++) {
			if (checkLine(b[i]) || checkLine(getColumn(b, i)))
				return true;
		}
		// Check diagonals
		return checkLine(getDiagonal(b, true)) || checkLine(getDiagonal(b, false));
	}

	@Override
	public boolean checkDraw(IGameBoard board) {
		// TODO Auto-generated method stub
		char[][] b = board.getBoard();
        for (char[] row : b) {
            for (char c : row) {
                if (c == ' ') return false;
            }
        }
        return true;
	}

	private char[] getColumn(char[][] b, int col) {
		int size = b.length;
		char[] column = new char[size];
		for (int i = 0; i < size; i++) {
			column[i] = b[i][col];
		}
		return column;
	}

	private char[] getDiagonal(char[][] b, boolean isMain) {
		int size = b.length;
		char[] diagonal = new char[size];
		for (int i = 0; i < size; i++) {
			diagonal[i] = isMain ? b[i][i] : b[i][size - i - 1];
		}
		return diagonal;
	}

	private boolean checkLine(char[] line) {
		char first = line[0];
		if (first == ' ')
			return false;
		for (char c : line) {
			if (c != first)
				return false;
		}
		return true;
	}
}
