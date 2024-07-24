package com.aurionpro.exceptions;

public class NegaativeAmountException extends RuntimeException{
	public String toMessage() {
		return "Amount should be a positive number";
	}

}