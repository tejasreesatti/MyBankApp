package com.capgemini.bankapplication.exception;
public class PayeeAccountNotFoundException extends Exception{

	public PayeeAccountNotFoundException(String message) {
		super(message);
	}
}