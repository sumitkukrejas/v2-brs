package com.brs.exceptions;

import java.util.Date;
import java.util.Map;

public class MethodErrorDetails {
	private Date timeStamp;
	private Map<String,String> message;
	private String details;
	public MethodErrorDetails(Date timeStamp, Map<String, String> message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp; 
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Map<String, String> getMessage() {
		return message;
	}
	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}