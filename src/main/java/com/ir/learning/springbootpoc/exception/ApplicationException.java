package com.ir.learning.springbootpoc.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;
	private String status;
	
	
	
	public ApplicationException(String exceptionMessage, String status) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.status = status;
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
