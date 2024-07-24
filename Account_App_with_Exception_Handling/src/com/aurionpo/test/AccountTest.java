package com.aurionpo.test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.aurionpo.exceptions.*;
import com.aurionpo.model.*;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Long,Account> accounts = new HashMap<>();
		int choice = -1;
			while(choice!=5) {
				System.out.println("\nWelcome to Banking");
			    System.out.println("1 -> Create New Bank Account ");
			    System.out.println("2 -> Deposit Money");
			    System.out.println("3 -> Withdraw Money");
			    System.out.println("4 -> Account details");
			    System.out.println("5 -> Exit");
			    System.out.print("Select : ");
				choice = scanner.nextInt();
				
				if(choice==1) {
					Account account = createBankAccount(accounts.keySet(),scanner);
					accounts.put(account.getAccno(), account);
				}
				else if(choice==2) {
					System.out.println("============Credit Menu============");
					try {
						Account account = getAccountByNumber(scanner, accounts);
						creditMenu(account,scanner);
					} catch (AccountNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println(e.toMessage());
					}
				}
				else if(choice==3) {
					try {
					System.out.println("=============Debit Menu============");
					Account account = getAccountByNumber(scanner, accounts);
					debitMenu(account,scanner);
					} catch (AccountNotFoundException e) {
						System.err.println(e.toMessage());
					}
				}
				else if(choice==4) {
					try {
					Account account = getAccountByNumber(scanner, accounts);
					System.out.println(account);
					} catch (AccountNotFoundException e) {
						System.err.println(e.toMessage());
					}
					
				}
			}
	}

	private static Account getAccountByNumber(Scanner scanner, HashMap<Long, Account> accounts) {
			System.out.print("Enter Account number: ");
			Long accountNumber = scanner.nextLong();
			Account account = accounts.get(accountNumber);
			if (account == null) {
				throw new AccountNotFoundException();
			}
			return account;
	}

	private static void debitMenu(Account account,Scanner scanner) {
		try {
			if(account!=null) {
				System.out.print("Enter the amount: ");
				double amount=scanner.nextDouble();
				account.debit(amount);
				System.out.println(account);
				return;
			}
			System.err.println("Account number does not exists");
		}
		catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			System.err.println(e.toMessage());
		}
		catch(InsufficantBalanceException e) {
			System.err.println(e.toMessage());
		}
	}
	
	private static void creditMenu(Account account,Scanner scanner) {
		try {
		if(account!=null) {
			System.out.print("Enter the amount: ");
			double amount=scanner.nextDouble();
			account.credit(amount);
			System.out.println(account);
			return;
		}
		System.err.println("Account number does not exists");
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			System.err.println(e.toMessage());
		}
		catch(InsufficantBalanceException e) {
			System.err.println(e.toMessage());
		}
	}

	private static Account createBankAccount(Set<Long> accountNumbers,Scanner scanner) {
        long accountNumber = generateUniqueAccountNumber(accountNumbers);
        System.out.println("\n======================================");
        System.out.println("Your account number is "+accountNumber);
        System.out.print("Enter your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        while(true) {
        	System.out.print("\nEnter Account Type\nEnter '1' for current and '2' for saving:");
        	int accountType = scanner.nextInt();
        	switch (accountType) {
			case 1:
				System.out.println("Creating current account...");
				System.out.print("Set a Over draft limit: ");
				double overDraftLimit = scanner.nextDouble();
				CurrentAccount currentAccount = new CurrentAccount(accountNumber ,name, balance, overDraftLimit);
				return currentAccount;
			case 2:
				double minAccountBalance = 1000;
				System.out.println("Creating savings account...");
				System.out.print("Minimum account balance is "+minAccountBalance);
				if (minAccountBalance>balance) {
					System.out.println("Minimum account balance criteria not met\nNew balance");
					balance = scanner.nextDouble();
					break;
				}
//				double minAccountBalance = scanner.nextDouble();  //Currently manually setting Minimum account balance 
				SavingAccount savingAccount = new SavingAccount(accountNumber, name, balance, minAccountBalance);
				return savingAccount;
			default:
				System.err.println("Enter a valid option");
				break;
			}
        	
        }

	}
	
	private static Long generateUniqueAccountNumber(Set<Long> accountNumbers) {
		long accountNumber; 
		while(true) {
	          accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	          if(!accountNumbers.contains(accountNumber)) {
	            break;
	            }
		}     
		return accountNumber;
	}

}
