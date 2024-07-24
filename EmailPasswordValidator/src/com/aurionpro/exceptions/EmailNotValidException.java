package com.aurionpro.exceptions;

public class EmailNotValidException extends RuntimeException {
	public String toMessage() {
		return "Email is not valid";
	}
}
