package com.handson.ps.dev.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private int errorCode;
	
	public ProductNotFoundException() {
		super();
	}
	public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ProductNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ProductNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public ProductNotFoundException(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ProductNotFoundException [message=" + message + ", errorCode=" + errorCode + "]";
	}
}
