package com.example.banking.models;

import java.util.LinkedHashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	
    private LinkedHashSet<ASPSP> aspsps;

	public LinkedHashSet<ASPSP> getAspsps() {
		return aspsps;
	}

	public void setAspsps(LinkedHashSet<ASPSP> aspsps) {
		this.aspsps = aspsps;
	}

	@Override
	public String toString() {
		return "Root [aspsps=" + aspsps + "]";
	}
    
    
}
