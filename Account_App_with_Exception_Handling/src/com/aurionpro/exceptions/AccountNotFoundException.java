package com.aurionpro.exceptions;

public class AccountNotFoundException extends RuntimeException {
	public String toMessage() {
		return "Account not Found";
	}
}
