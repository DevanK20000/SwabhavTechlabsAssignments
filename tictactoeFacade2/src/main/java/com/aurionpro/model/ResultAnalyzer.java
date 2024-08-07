package com.aurionpro.model;

public class ResultAnalyzer {
	private Board board;
	private ResultType result;

	public ResultAnalyzer(Board board, ResultType result) {
		super();
		this.board = board;
		this.result = result;
	}
	
	public ResultType anlyzeResult() {
		horizontalWinCheck();
		if(result.equals(ResultType.WIN))
			return result;
		verticallWinCheck();
		if(result.equals(ResultType.WIN))
			return result;
		diagonalWinCheck();
		if(result.equals(ResultType.WIN))
			return result;
		if (board.isBoardFull()) {
			result = ResultType.DRAW;
		}
		return result;
	}

	private void horizontalWinCheck() {
		int size = board.getSize();
		for (int i = 0; i < size; i++) {
			if (checkLine(board.getCell()[i])) {
				result = ResultType.WIN;
				return;
			}
		}
		result = ResultType.PROGRESS;
	}
	
	private Cell[] getColumn(int col) {
		int size = board.getSize();
		Cell[] column = new Cell[size];
		for (int i = 0; i < size; i++) {
			column[i] = new Cell();
		}
		for (int i = 0; i < size; i++) {
			column[i].setMark(board.getCell()[i][col].getMark());
		}
		return column;
	}

	private void verticallWinCheck() {
		int size = board.getSize();
		for (int i = 0; i < size; i++) {
			Cell[] column = getColumn(i);
			if (checkLine(column)) {
				result = ResultType.WIN;
				return;
			}
		}
		result = ResultType.PROGRESS;
	}

	private void diagonalWinCheck() {
		if (checkLine(getDiagonal(true)) || checkLine(getDiagonal(false))) {
			result = ResultType.WIN;
			return;
		}
		result = ResultType.PROGRESS;
	}

	private Cell[] getDiagonal(boolean isMain) {
		int size = board.getSize();
		Cell[] diagonal = new Cell[size];
		for (int i = 0; i < size; i++) {
			diagonal[i] = new Cell();
		}
		for (int i = 0; i < size; i++) {
			diagonal[i] = isMain ? board.getCell()[i][i] : board.getCell()[i][size - i - 1];
		}
		return diagonal;

	}

	private boolean checkLine(Cell[] cells) {
		Cell first = cells[0];
		if (first.getMark().equals(MarkType.EMPTY))
			return false;
		for (Cell c : cells) {
			if (c.getMark() != first.getMark())
				return false;
		}
		return true;
	}
}
