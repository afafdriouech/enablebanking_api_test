package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthentUrl {

    private Aspsp aspsp;
    private String state;
    private String redirect_url;
    private String language;
    private Aspsp getAspsp() {
		return aspsp;
	}
	public void setAspsp(Aspsp aspsp) {
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "AuthentUrl [aspsp=" + aspsp + ", state=" + state + ", redirect_url=" + redirect_url + ", language="
				+ language + "]";
	}
    
}
