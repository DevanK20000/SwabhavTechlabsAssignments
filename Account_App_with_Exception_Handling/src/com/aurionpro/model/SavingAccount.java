package com.aurionpro.model;

import com.aurionpro.exceptions.InsufficantBalanceException;
import com.aurionpro.exceptions.InvalidAmountException;

public class SavingAccount extends Account {
	private Double MIN_BALANCE;

	public SavingAccount(Long accno, String name, double balance, Double MIN_BALANCE) {
		super(accno, name, balance);
		this.MIN_BALANCE = MIN_BALANCE;
	}

	public Double getMIN_BALANCE() {
		return MIN_BALANCE;
	}

	public void setMIN_BALANCE(Double mIN_BALANCE) {
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
	public void debit(Double amount) {
		if(amount<=0) {
			throw new InvalidAmountException();
		}
		Double balance = getBalance();
		if (balance>=amount && balance-amount>=MIN_BALANCE) {
			setBalance(balance-amount);
			return;
		}
		throw new InsufficantBalanceException(balance,MIN_BALANCE,true);
	}
 
}
