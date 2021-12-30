package com.example.banking.models;

import java.time.ZonedDateTime;

public class Access {

    private ZonedDateTime valid_until;

    
	public Access() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZonedDateTime getValid_until() {
		return valid_until;
	}

	public void setValid_until(ZonedDateTime valid_until) {
		this.valid_until = valid_until;
	}

	public Access(ZonedDateTime dateTime) {
		this.valid_until = dateTime;
	}
    
}
