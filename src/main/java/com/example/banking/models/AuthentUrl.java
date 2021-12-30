package com.example.banking.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthentUrl {

    private Access access;
    private ASPSP aspsp;    
    private String state;
    private String redirect_url;
    
    
    public AuthentUrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthentUrl(Access access, ASPSP aspsp, String state, String redirect_url) {
		this.access = access;
		this.aspsp = new ASPSP(aspsp.getName(),aspsp.getCountry());
		this.state = state;
		this.redirect_url = redirect_url;
	}

	public ASPSP getAspsp() {
		return aspsp;
	}

	public void setAspsp(ASPSP aspsp) {
		this.aspsp = aspsp;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}
    
}
