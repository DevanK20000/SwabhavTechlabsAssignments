package com.aurionpro.model;

import com.aurionpro.exceptions.InvalidAmountException;

public class Account {
	private Long accno;
	private String name;
	private Double balance;
	public Account(Long accno, String name, Double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}
	public Long getAccno() {
		return accno;
	}
	public void setAccno(Long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void debit(Double amount) {
		if(amount<=0) {
			throw new InvalidAmountException();
		}
		if (balance>=amount) {
			balance = balance - amount;
			return;
		}
		System.err.println("amount lower than balance");
	}
	
	public void credit(Double amount) {
		if(amount<=0) {
			throw new InvalidAmountException();
		}
		balance = balance +amount;
	}
	
	
}
