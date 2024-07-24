package com.aurionpro.model;

import com.aurionpro.exceptions.InsufficaientFundsException;
import com.aurionpro.exceptions.NegaativeAmountException;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	public void debit(double amount) {
		if(amount<0) {
			throw new NegaativeAmountException();
		}
		if (balance>=amount) {
			balance = balance - amount;
			return;
		}
		throw new InsufficaientFundsException(balance);
	}
	
	public void credit(double amount) {
		if(amount<0) {
			throw new NegaativeAmountException();
		}
		balance = balance +amount;
	}
	
}
