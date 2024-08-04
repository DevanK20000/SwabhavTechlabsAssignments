package com.aurionpro.model;

public interface IGameBoard {
	void setSize(int size);
	void makeMove(int row, int col,char player);
	char[][] getBoard();
	void printBoard();
}
