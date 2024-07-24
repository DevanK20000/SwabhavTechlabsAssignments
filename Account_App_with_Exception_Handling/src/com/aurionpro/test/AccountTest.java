package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import com.aurionpro.exceptions.AccountNotFoundException;
import com.aurionpro.exceptions.InsufficantBalanceException;
import com.aurionpro.exceptions.InvalidAmountException;
import com.aurionpro.model.Account;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAccount;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accounts = new ArrayList<Account>();
		int choice = -1;
			while(choice!=7) {
				System.out.println("\nWelcome to Banking");
			    System.out.println("1 -> Create New Bank Account ");
			    System.out.println("2 -> Deposit Money");
			    System.out.println("3 -> Withdraw Money");
			    System.out.println("4 -> Account details");
			    System.out.println("5 -> All account");
			    System.out.println("6 -> Maxium balance account");
			    System.out.println("7 -> Exit");
			    System.out.print("Select : ");
				choice = scanner.nextInt();
				
				if(choice==1) {
					Account account = createBankAccount(scanner,accounts);
					accounts.add(account);
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
				else if(choice==5) {
					try {
						accountsDecendingBalance(accounts);
					} catch (AccountNotFoundException e) {
						System.err.println(e.toMessage());
					}
				}
				else if(choice==6) {
					try {
						sortAccounts(accounts);
						System.out.println(accounts.get(0));
					} catch (AccountNotFoundException e) {
						System.err.println(e.toMessage());
					}
				}
			}
	}

	private static void accountsDecendingBalance(ArrayList<Account> accounts) {
			sortAccounts(accounts);
			for(Account account:accounts) {
				System.out.println("========================================");
				System.out.println(account);
			}
	}

	private static void sortAccounts(ArrayList<Account> accounts) {
		if(!accounts.isEmpty()) {
			Comparator<Account> customComparator = Comparator.comparing(Account::getBalance);
			accounts.sort(customComparator.reversed());
			return;
		}
		throw new AccountNotFoundException();
		}

	private static Account getAccountByNumber(Scanner scanner, ArrayList<Account> accounts) {
			System.out.print("Enter Account number: ");
			Long accountNumber = scanner.nextLong();
			for(Account account:accounts) {
				if(account.getAccno().equals(accountNumber)) {
					return account;
				}
			}
			throw new AccountNotFoundException();
			
	}

	private static void debitMenu(Account account,Scanner scanner) {
		try {
			if(account!=null) {
				System.out.print("Enter the amount: ");
				Double amount=scanner.nextDouble();
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
			Double amount=scanner.nextDouble();
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

	private static Account createBankAccount(Scanner scanner,ArrayList<Account> accounts) {
        long accountNumber = generateUniqueAccountNumber(accounts);
        System.out.println("\n======================================");
        System.out.println("Your account number is "+accountNumber);
        System.out.print("Enter your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter balance: ");
        Double balance = scanner.nextDouble();
        while(true) {
        	System.out.print("\nEnter Account Type\nEnter '1' for current and '2' for saving:");
        	int accountType = scanner.nextInt();
        	switch (accountType) {
			case 1:
				System.out.println("Creating current account...");
				System.out.print("Set a Over draft limit: ");
				Double overDraftLimit = scanner.nextDouble();
				CurrentAccount currentAccount = new CurrentAccount(accountNumber ,name, balance, overDraftLimit);
				return currentAccount;
			case 2:
				Double minAccountBalance = 1000.0;
				System.out.println("Creating savings account...");
				System.out.print("Minimum account balance is "+minAccountBalance);
				if (minAccountBalance>balance) {
					System.out.println("Minimum account balance criteria not met\nNew balance");
					balance = scanner.nextDouble();
					break;
				}
//				Double minAccountBalance = scanner.nextDouble();  //Currently manually setting Minimum account balance 
				SavingAccount savingAccount = new SavingAccount(accountNumber, name, balance, minAccountBalance);
				return savingAccount;
			default:
				System.err.println("Enter a valid option");
				break;
			}
        	
        }

	}
	
	private static Long generateUniqueAccountNumber(ArrayList<Account> accounts) {
		long accountNumber;
		ArrayList<Long> accountNumbers = new ArrayList<Long>();
		for(Account account:accounts) {
			accountNumbers.add(account.getAccno());
		}
		while(true) {
	          accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	          if(accountNumbers == null || !accountNumbers.contains(accountNumber)) {
	            break;
	            }
		}
		return accountNumber;
	}

}
