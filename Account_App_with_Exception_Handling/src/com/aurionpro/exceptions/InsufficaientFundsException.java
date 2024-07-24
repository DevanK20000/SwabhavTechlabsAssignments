package com.aurionpro.exceptions;

public class InsufficaientFundsException extends RuntimeException{
	private double balance;

	public InsufficaientFundsException(double balance) {
		super();
		this.balance = balance;
	}
	public String toMessage() {
		return "Amount should be less than balance\nBalance is "+balance;
	}

}
