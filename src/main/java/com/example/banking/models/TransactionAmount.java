package com.example.banking.models;

public class TransactionAmount {

    private String currency;
    private String amount;
	public TransactionAmount(String currency, String amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}
	public TransactionAmount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
    
}
