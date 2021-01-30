package com.anand.task.entity;

/**
 * TaskCustomException is implemented as a COMMON class for all the Exceptions.
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public class TaskCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String errorMessage; //Exception Message

	public TaskCustomException(String exceptionMsg) {
		super(exceptionMsg);
		this.errorMessage = exceptionMsg;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
}