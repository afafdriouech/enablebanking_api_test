package com.example.banking.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {
	
    private String session_id;
    private List<Account> accounts;
    private ASPSP aspsp;
    private String psu_type;
    private Access access;
    
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Session(String session_id, List<Account> accounts, ASPSP aspsp, String psu_type, Access access) {
		this.session_id = session_id;
		this.accounts = accounts;
		this.aspsp = aspsp;
		this.psu_type = psu_type;
		this.access = access;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public ASPSP getAspsp() {
		return aspsp;
	}
	public void setAspsp(ASPSP aspsp) {
		this.aspsp = aspsp;
	}
	public String getPsu_type() {
		return psu_type;
	}
	public void setPsu_type(String psu_type) {
		this.psu_type = psu_type;
	}
	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}
    
    
}
