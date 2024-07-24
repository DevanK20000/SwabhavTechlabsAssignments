package com.aurionpro.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aurionpro.exceptions.EmailNotValidException;
import com.aurionpro.exceptions.PasswordNotValidException;


public class User {
	private String email;
	private String password;
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
	
	private static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
	}
	
	private static boolean validatePassword(String passwordStr) {
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordStr);
		return matcher.matches();
	}	
	
	public User(String email, String password) {
		super();
		if (!validateEmail(email)) {
			throw new EmailNotValidException();
		}
		if (!validatePassword(password)) {
			throw new PasswordNotValidException();
		}
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(!validateEmail(email)) {
			throw new EmailNotValidException();
		}
		this.email = email;			
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(!validatePassword(password)) {
			throw new PasswordNotValidException();
		}
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
}
