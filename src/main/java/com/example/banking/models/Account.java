package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
	
	private String name;
    private String details;
    private String linked_account;
    private String usage;
    private String product;
    private String currency;
    private String uid;
    private String identification_hash;
    
    
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String name, String details, String linked_account, String usage, String product, String currency,
			String uid, String identification_hash) {
		this.name = name;
		this.details = details;
		this.linked_account = linked_account;
		this.usage = usage;
		this.product = product;
		this.currency = currency;
		this.uid = uid;
		this.identification_hash = identification_hash;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getLinked_account() {
		return linked_account;
	}
	public void setLinked_account(String linked_account) {
		this.linked_account = linked_account;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getIdentification_hash() {
		return identification_hash;
	}
	public void setIdentification_hash(String identification_hash) {
		this.identification_hash = identification_hash;
	}
    
	
    

}
