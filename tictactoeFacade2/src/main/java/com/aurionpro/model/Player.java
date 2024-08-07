package com.aurionpro.model;

public class Player {
	private String playerName;
	private MarkType mark;
	public Player(String playerName, MarkType mark) {
		super();
		this.playerName = playerName;
		this.mark = mark;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public MarkType getMark() {
		return mark;
	}
	public void setMark(MarkType mark) {
		this.mark = mark;
	}
	
	

}
