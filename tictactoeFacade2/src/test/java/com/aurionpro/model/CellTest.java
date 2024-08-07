package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
	Cell cell;
	
	@BeforeEach
	void init(){
		cell = new Cell();
	}
	
	@Test
	void testCreatedCellIsEmpty() {
		assertEquals(MarkType.EMPTY, cell.getMark());
	}
	
	@Test
	void testMark_checkIfCanMarkX() {
		cell.setMark(MarkType.X);
		assertEquals(MarkType.X, cell.getMark());
	}
	
	@Test
	void testMark_checkIfCanMarkO() {
		cell.setMark(MarkType.O);
		assertEquals(MarkType.O, cell.getMark());
	}
	
	//cell exception tested in board

}
