package com.application.exception;

public class DataValidationException extends Exception {
	
	private static final long serialVersionUID = -5L;
	
	public DataValidationException(String msg){
		super(msg);
	}
	
	public DataValidationException(Throwable th) {
		super(th);
	}
	
	public DataValidationException(String msg, Throwable th) {
		super(msg, th);
	}
}
