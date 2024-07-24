package com.aurionpro.model;

import com.aurionpro.exceptions.InsufficantBalanceException;
import com.aurionpro.exceptions.InvalidAmountException;

public class CurrentAccount extends Account{
	private Double OVER_DRAFT_LIMIT;
	private Double overDraftLimitAvailableLimit;

	public CurrentAccount(Long accno, String name, Double balance,Double OVER_DRAFT_LIMIT) {
		super(accno, name, balance);
		this.OVER_DRAFT_LIMIT = OVER_DRAFT_LIMIT;
		overDraftLimitAvailableLimit = OVER_DRAFT_LIMIT;
		// TODO Auto-generated constructor stub
	}

	public Double getOVER_DRAFT_LIMIT() {
		return OVER_DRAFT_LIMIT;
	}

	public void setOVER_DRAFT_LIMIT(Double oVER_DRAFT_LIMIT) {
		OVER_DRAFT_LIMIT = oVER_DRAFT_LIMIT;
	}
	
	

	public Double getOverDraftLimitAvailableLimit() {
		return overDraftLimitAvailableLimit;
	}


	
	@Override
	public String toString() {
		return "\nAccount number: "+getAccno()
			+"\nName: "+getName()
			+"\nBalance: "+getBalance()
			+"\nAccount Type: Current"
			+"\nCurrent over draft limit: "+overDraftLimitAvailableLimit
			+"\nMax over draft limit: "+OVER_DRAFT_LIMIT;
	}

	@Override
	public void debit(Double amount) {
		if(amount<=0) {
			throw new InvalidAmountException();
		}
		if (amount<=getBalance()) {
			setBalance(getBalance()-amount);
			return;
		}
		if (getBalance()+overDraftLimitAvailableLimit>=amount) {
			overDraftLimitAvailableLimit = getBalance()+overDraftLimitAvailableLimit-amount;
			setBalance(0.0);
			System.out.println("Used Over draft limit\nNew over draft limit available: "+overDraftLimitAvailableLimit+"\nMax over draft limit: "+OVER_DRAFT_LIMIT);
			return;
		}
		throw new InsufficantBalanceException(getBalance(),overDraftLimitAvailableLimit);
	}
	
	@Override
	public void credit(Double amount) {
		if(amount<=0) {
			throw new InvalidAmountException();
		}
		if(overDraftLimitAvailableLimit==OVER_DRAFT_LIMIT) {
			setBalance(getBalance()+amount);
			return;
		}
		if(amount<=OVER_DRAFT_LIMIT) {
			overDraftLimitAvailableLimit += amount;
			System.out.println("Used Over draft credited\nNew over draft limit available: "+overDraftLimitAvailableLimit+"\nMax over draft limit: "+OVER_DRAFT_LIMIT);
			return;
		} 
		Double limit = overDraftLimitAvailableLimit-amount;
		overDraftLimitAvailableLimit = OVER_DRAFT_LIMIT;
		setBalance(limit);
		System.out.println("Used Over draft credited\nNew over draft limit available: "+overDraftLimitAvailableLimit+"\nMax over draft limit: "+OVER_DRAFT_LIMIT);
	}
	
	

}
