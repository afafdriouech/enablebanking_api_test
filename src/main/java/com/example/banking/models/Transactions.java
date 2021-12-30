package com.example.banking.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Transactions {

    private List<Transaction> transactions;
    private String continuation_key;
    
    
	public Transactions() {
		super();
	}

	public Transactions(List<Transaction> transactions, String continuation_key) {
		this.transactions = transactions;
		this.continuation_key = continuation_key;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getContinuation_key() {
		return continuation_key;
	}

	public void setContinuation_key(String continuation_key) {
		this.continuation_key = continuation_key;
	}

	@Override
	public String toString() {
		return "Transactions [transactions=" + transactions + ", continuation_key=" + continuation_key + "]";
	}
    
	
    
}
