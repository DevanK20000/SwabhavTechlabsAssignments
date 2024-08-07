package com.aurionpro.model;

import com.aurionpro.exception.InvalidLocationException;

public class Board {
	private int size;
	Cell[][] cell;

	public Board(int size) {
		super();
		this.size = size;
		this.cell = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.cell[i][j] = new Cell();
			}
		}
	}

	public int getSize() {
		return size;
	}

	public Cell[][] getCell() {
		return cell;
	}

	public boolean isBoardFull() {
		for (Cell[] row : cell) 
		{
			for (Cell c : row) 
			{
				if (c.isEmpty())
					return false;
			}
		}
		return true;
	}

	public void setCellMark(int row, int col, MarkType mark) {
		if(row >= size || col >= size){
			throw new InvalidLocationException();
		}
		cell[row][col].setMark(mark);
	}
	
	public void printBoard()
	{
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				switch (cell[i][j].getMark()) {
				case O:
					System.out.print("O");
					break;
				case X:
					System.out.print("X");
				default:
					System.out.print(" ");
					break;
				}
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
