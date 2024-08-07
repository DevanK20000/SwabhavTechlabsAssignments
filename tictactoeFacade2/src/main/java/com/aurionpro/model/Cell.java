package com.aurionpro.model;

import com.aurionpro.exception.CellAlreadyMarkedException;

public class Cell {
	MarkType mark;

	public Cell() {
		super();
		this.mark = MarkType.EMPTY;
	}
	
	public boolean isEmpty() {
		return mark.equals(MarkType.EMPTY);
	}

	public MarkType getMark() {
		return mark;
	}

	public void setMark(MarkType mark) {
		if (!isEmpty())
			throw new CellAlreadyMarkedException();
		this.mark = mark;
	}
	
	
}
