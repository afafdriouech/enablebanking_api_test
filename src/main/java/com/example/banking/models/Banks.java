package com.example.banking.models;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Banks {

	private Map<String, List<Bank>> bank;

	public Map<String, List<Bank>> getBank() {
		return bank;
	}

	public void setBank(Map<String, List<Bank>> bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Banks [bank=" + bank + "]";
	}
	
	
}
