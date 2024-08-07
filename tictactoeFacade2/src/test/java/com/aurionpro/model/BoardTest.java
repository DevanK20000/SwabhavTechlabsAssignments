package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aurionpro.exception.CellAlreadyMarkedException;
import com.aurionpro.exception.InvalidLocationException;

class BoardTest {
	Board board;
	int size;

	@BeforeEach
	void inti() {
		size = 3;
		board = new Board(size);
	}

	@Test
	void testCreateBoard_allCellsAreEmpty() {
		Cell[][] actual = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				actual[i][j] = new Cell();
				actual[i][j].setMark(MarkType.EMPTY);
			}

		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				assertEquals(actual[i][j].getMark(), board.getCell()[i][j].getMark());

			}

		}

	}

	@Test
	void testCellMark_ableToMarkASpecificLoacation() {
		int row = 1;
		int col = 2;
		MarkType mark = MarkType.X;
		board.setCellMark(row, col, mark);
		assertEquals(MarkType.X, board.getCell()[row][col].getMark());
	}

	@Test
	void testIsBoardFull() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board.setCellMark(i, j, MarkType.X);
			}
		}
		assertTrue(board.isBoardFull());
	}
	
	@Test
	void testIsNotFull() {
		assertFalse(board.isBoardFull());
	}
	
	@Test
	void testCellMark_throwCellAlreadyMarkedException() {
		board.setCellMark(0, 0, MarkType.O);
		assertThrowsExactly(CellAlreadyMarkedException.class, ()->board.setCellMark(0, 0, MarkType.O));
		assertThrowsExactly(CellAlreadyMarkedException.class, ()->board.setCellMark(0, 0, MarkType.X));
	}
	
	@Test
	void testCellMark_throwInvalidLocationException() {
		assertThrowsExactly(InvalidLocationException.class, ()->board.setCellMark(5, 5, MarkType.X));
	}
}
