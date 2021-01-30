package com.anand.task.constants;

/**
 * URLCons is a constant class used for maintaining all JSP file names and URLs
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public class URLCons {

	/**
	 * URLCons() is a private constructor to hide the implicit public one
	 */
	private URLCons() {
		throw new IllegalStateException();
	}

	public static final String GET_EMPLOYEE = "/getEmployee";
	public static final String LOAD_EMPLOYEE = "/loadAllEmployee";
	public static final String CREATE_EMPLOYEE = "/createEmployee";
	public static final String UPDATE_EMPLOYEE = "/updateEmployee";
	public static final String DELETE_EMPLOYEE = "/deleteEmployee";

	public static final String JSON_UTF8_ENCODING = "application/json; charset=UTF-8";
}