package com.aurionpo.exceptions;

public class InsufficantBalanceException extends RuntimeException {
	private double balance;
	private Double availableOverDraftLimit = -1.0;
	private Double minBalance = -1.0;
	
	public InsufficantBalanceException(double balance) {
		super();
		this.balance = balance;
	}

	public InsufficantBalanceException(double balance, double availableOverDraftLimit) {
		super();
		this.balance = balance;
		this.availableOverDraftLimit = availableOverDraftLimit;
	}
	
	public InsufficantBalanceException(double balance, double minBalance, Boolean isMinBalance) {
		super();
		this.balance = balance;
		this.minBalance = minBalance;
	}
	
	public String toMessage() {
		if(!availableOverDraftLimit.equals(-1.0)) {
			return "Insufficant balance or Over draft limit\nBalance: "+balance+"\nOver draft lmit: "+availableOverDraftLimit+"\nTotal widrawable amount: "+(balance+availableOverDraftLimit);
		}
		if(!minBalance.equals(-1.0))
		{
			return "Minium balance excede\nBalance: "+balance+"\nWidrawable amount: "+(balance-minBalance);
		}
		return "Insufficant balance\nAvailable balance: "+balance;
	}
}