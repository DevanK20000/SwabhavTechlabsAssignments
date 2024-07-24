package com.aurionpro.exceptions;

public class PasswordNotValidException extends RuntimeException {
	public String toMessage() {
		return "Password not valid\nPassword should atleast be 8 character long and should contain:\n\t uppercase character,\n\t special character,\n\t digit charcter.";
	}
}
