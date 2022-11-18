package com.brs.exceptions;

public class RouteNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RouteNotFoundException(String message)
	{
		super(message);
	}

}
