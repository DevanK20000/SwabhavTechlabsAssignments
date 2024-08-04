package com.aurionpro.model;

public interface IGameRules {
	boolean checkWin(IGameBoard board);
	boolean checkDraw(IGameBoard board);
}
