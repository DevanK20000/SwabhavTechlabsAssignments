package com.aurionpo.model;

public class Account {
	private Long accno;
	private String name;
	private double balance;
	public Account(Long accno, String name, double balance) {
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void debit(double amount) {
		if (balance>=amount) {
			balance = balance - amount;
			return;
		}
		System.err.println("amount lower than balance");
	}
	
	public void credit(double amount) {
		balance = balance +amount;
	}
	
	
}
