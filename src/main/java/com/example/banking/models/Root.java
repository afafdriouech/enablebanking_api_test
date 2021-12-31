package com.example.banking.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	
    private List<ASPSP> aspsps;
        
	public Root() {
		super();
	}

	public Root(List<ASPSP> aspsps) {
		this.aspsps = aspsps;
	}

	public List<ASPSP> getAspsps() {
		return aspsps;
	}

	public void setAspsps(List<ASPSP> aspsps) {
		this.aspsps = aspsps;
	}
	
	public String findCountry(String bank)
	{
		int i=this.aspsps.indexOf(bank);
		return this.aspsps.get(i).getCountry();
	}

	@Override
	public String toString() {
		return "Root [aspsps=" + aspsps + "]";
	}
    
    
}
