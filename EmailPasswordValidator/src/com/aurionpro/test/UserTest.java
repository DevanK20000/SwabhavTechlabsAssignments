package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exceptions.EmailNotValidException;
import com.aurionpro.exceptions.PasswordNotValidException;
import com.aurionpro.model.User;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		try {
			user = new User(email, password);
		}
		catch (EmailNotValidException e) {
			System.out.println(e.toMessage());
		}
		catch (PasswordNotValidException e) {
			System.out.println(e.toMessage());
		}
		System.out.println(user);
	}
	
}
