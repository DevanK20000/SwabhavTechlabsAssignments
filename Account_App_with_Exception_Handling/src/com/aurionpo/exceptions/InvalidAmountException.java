package com.aurionpo.exceptions;

public class InvalidAmountException extends RuntimeException {
	public String toMessage() {
		return "Enter a valid Amount";
	}
}
