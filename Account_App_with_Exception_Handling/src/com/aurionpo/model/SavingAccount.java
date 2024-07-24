package com.aurionpo.model;

import com.aurionpo.exceptions.*;

public class SavingAccount extends Account {
	private double MIN_BALANCE;

	public SavingAccount(Long accno, String name, double balance, double MIN_BALANCE) {
		super(accno, name, balance);
		this.MIN_BALANCE = MIN_BALANCE;
	}

	public double getMIN_BALANCE() {
		return MIN_BALANCE;
	}

	public void setMIN_BALANCE(double mIN_BALANCE) {
		MIN_BALANCE = mIN_BALANCE;
	}

	@Override
	public String toString() {
		return "\nAccount number: "+getAccno()
			+"\nName: "+getName()
			+"\nBalance: "+getBalance()
			+"\nAccount Type: Saving"
			+"\nMinimum Balance: "+MIN_BALANCE;
	}
	
	@Override
	public void debit(double amount) {
		if(amount<=0) {
			throw new InvalidAmountException();
		}
		double balance = getBalance();
		if (balance>=amount && balance-amount>=MIN_BALANCE) {
			setBalance(balance-amount);
			return;
		}
		throw new InsufficantBalanceException(balance,MIN_BALANCE,true);
	}
 
}
