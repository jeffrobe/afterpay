package com.afterpay.model;

import java.util.Date;

public class CreditCardTransaction {

	private String hsh;
	private double amount;
	private Date entered;

	public String getHsh() {
		return hsh;
	}

	public void setHsh(String v) {
		this.hsh = v;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(float v) {
		this.amount = v;
	}

	public Date getEntered() {
		return entered;
	}

	public void setEntered(Date v) {
		this.entered = v;
	}

	public CreditCardTransaction() {

	}

	public CreditCardTransaction(String hsh, Date dt, Double amount) {
		this.hsh = hsh;
		this.entered = dt;
		this.amount = amount;

	}

}
