package com.example.banking.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String entry_reference;
    private TransactionAmount transaction_amount;
    private String transaction_date;
    private String reference_number;
    
    
	public Transaction() {
		super();
	}

	
	public Transaction(String entry_reference, TransactionAmount transaction_amount, String transaction_date,
			String reference_number) {
		super();
		this.entry_reference = entry_reference;
		this.transaction_amount = transaction_amount;
		this.transaction_date = transaction_date;
		this.reference_number = reference_number;
	}


	public String getEntry_reference() {
		return entry_reference;
	}
	public void setEntry_reference(String entry_reference) {
		this.entry_reference = entry_reference;
	}

	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getReference_number() {
		return reference_number;
	}
	public void setReference_number(String reference_number) {
		this.reference_number = reference_number;
	}
	public TransactionAmount getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(TransactionAmount transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	
    
}
