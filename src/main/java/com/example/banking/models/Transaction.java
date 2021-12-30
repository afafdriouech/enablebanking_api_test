package com.example.banking.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String entry_reference;
    private String merchant_category_code;
    //public TransactionAmount transaction_amount;
    //public Creditor creditor;
    //public CreditorAccount creditor_account;
    //public Debtor debtor;
    //public DebtorAccount debtor_account;
    //public BankTransactionCode bank_transaction_code;
    private String credit_debit_indicator;
    private String status;
    private String booking_date;
    private String value_date;
    private String transaction_date;
    //public BalanceAfterTransaction balance_after_transaction;
    private String reference_number;
    private List<String> remittance_information;
    
    
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String entry_reference, String merchant_category_code, String credit_debit_indicator,
			String status, String booking_date, String value_date, String transaction_date, String reference_number,
			List<String> remittance_information) {
		super();
		this.entry_reference = entry_reference;
		this.merchant_category_code = merchant_category_code;
		this.credit_debit_indicator = credit_debit_indicator;
		this.status = status;
		this.booking_date = booking_date;
		this.value_date = value_date;
		this.transaction_date = transaction_date;
		this.reference_number = reference_number;
		this.remittance_information = remittance_information;
	}
	public String getEntry_reference() {
		return entry_reference;
	}
	public void setEntry_reference(String entry_reference) {
		this.entry_reference = entry_reference;
	}
	public String getMerchant_category_code() {
		return merchant_category_code;
	}
	public void setMerchant_category_code(String merchant_category_code) {
		this.merchant_category_code = merchant_category_code;
	}
	public String getCredit_debit_indicator() {
		return credit_debit_indicator;
	}
	public void setCredit_debit_indicator(String credit_debit_indicator) {
		this.credit_debit_indicator = credit_debit_indicator;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getValue_date() {
		return value_date;
	}
	public void setValue_date(String value_date) {
		this.value_date = value_date;
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
	public List<String> getRemittance_information() {
		return remittance_information;
	}
	public void setRemittance_information(List<String> remittance_information) {
		this.remittance_information = remittance_information;
	}
    
    
}
