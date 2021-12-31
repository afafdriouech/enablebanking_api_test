package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ASPSP {

    private String name;
    private String country;
    
	public ASPSP() {
		super();
	}
	
	
	/*public ASPSP(String name) {
		this.name = name;
	}*/


	public ASPSP(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return name+"\n";
	}
    
    
}
