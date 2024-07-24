package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exceptions.InsufficaientFundsException;
import com.aurionpro.exceptions.NegaativeAmountException;
import com.aurionpro.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			Account account = createAccount(scanner);
			double amount;
			int choice = -1;
			while (true) {
				System.out.println("\n1)Credit\n2)Debit");
				choice = scanner.nextInt();
				while (choice != 3) {
					if (choice == 1) {
						System.out.print("\nEnter amount to be credited: ");
						amount = scanner.nextDouble();
						account.credit(amount);
						System.out.print("New Balance: " + account.getBalance());
						continue;
					}
					if (choice == 2) {
						System.out.print("\nEnter amount to be debited: ");
						amount = scanner.nextDouble();
						account.debit(amount);
						System.out.println("New Balance: " + account.getBalance());
						continue;
					}

					System.out.println("Enter valid input");

				}
			}
		} catch (InsufficaientFundsException e) {
			System.err.println(e.toMessage());
		} catch (NegaativeAmountException e) {
			System.err.println(e.toMessage());
		}

	}

	private static Account createAccount(Scanner scanner) {
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter balance: ");
		double balance = scanner.nextDouble();

		if (balance < 0) {
			throw new NegaativeAmountException();
		}

		Account account = new Account(accountNumber, name, balance);
		return account;
	}

}
