package model.entities;

import model.exceptions.WithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		super();
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		if(amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(Double amount) throws WithdrawException {
		if(amount > this.withdrawLimit)
			throw new WithdrawException("The amout exceeds withdraw limit");
		
		if(this.balance < amount)
			throw new WithdrawException("Not enough balance");
		this.balance -= amount;
	}
	
}
