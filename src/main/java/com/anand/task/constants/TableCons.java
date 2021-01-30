package com.anand.task.constants;

/**
 * TableCons is a constant class used for all MySQL table inputs
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public class TableCons {

	/**
	 * TableCons() is a private constructor to hide the implicit public one
	 */
	private TableCons() {
		throw new IllegalStateException();
	}

	public static final int MAX_LIMIT_NO = 50;

	public static final String TABLE_NAME = "EMPLOYEE_DETAILS";
	public static final String COL_1_ID = "ID";
	public static final String COL_2_FIRST_NAME = "FIRST_NAME";
	public static final String COL_3_LAST_NAME = "LAST_NAME";
	public static final String COL_4_EMAIL_ID = "EMAIL_ID";
	public static final String COL_5_AGE = "AGE";
	public static final String COL_6_GENDER = "GENDER";
	public static final String COL_7_ADDRESS = "ADDRESS";

	public static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;
	public static final String EMP_SEL_QUERY = getEmployeeSelectQuery();
	public static final String INSERT_QUERY = getInsertQuery();
	public static final String UPDATE_QUERY = getUpdateQuery();
	public static final String DELETE_QUERY = getDeleteQuery();

	private static String getEmployeeSelectQuery() {
		StringBuilder selQuery = new StringBuilder();
		selQuery.append("SELECT * FROM ");
		selQuery.append(" WHERE ");
		selQuery.append(COL_1_ID).append(" = ? ");
		return selQuery.toString();
	}

	private static String getInsertQuery() {
		StringBuilder insertQuery = new StringBuilder();
		insertQuery.append("INSERT INTO ");
		insertQuery.append(TABLE_NAME);
		insertQuery.append(" (");
		insertQuery.append(COL_1_ID).append(", ");
		insertQuery.append(COL_2_FIRST_NAME).append(", ");
		insertQuery.append(COL_3_LAST_NAME).append(", ");
		insertQuery.append(COL_4_EMAIL_ID).append(", ");
		insertQuery.append(COL_5_AGE).append(", ");
		insertQuery.append(COL_6_GENDER).append(", ");
		insertQuery.append(COL_7_ADDRESS);
		insertQuery.append(") SELECT ?, ?, ?, ?, ?, ?, ?");
		return insertQuery.toString();
	}

	private static String getUpdateQuery() {
		StringBuilder updateQuery = new StringBuilder();
		updateQuery.append("UPDATE ").append(TABLE_NAME).append(" SET ");
		updateQuery.append(COL_2_FIRST_NAME).append(" = ?, ");
		updateQuery.append(COL_3_LAST_NAME).append(" = ?, ");
		updateQuery.append(COL_4_EMAIL_ID).append(" = ?, ");
		updateQuery.append(COL_5_AGE).append(" = ?, ");
		updateQuery.append(COL_6_GENDER).append(" = ?, ");
		updateQuery.append(COL_7_ADDRESS).append(" = ?");
		updateQuery.append(" WHERE ");
		updateQuery.append(COL_1_ID).append(" = ?");
		return updateQuery.toString();
	}

	private static String getDeleteQuery() {
		StringBuilder deleteQuery = new StringBuilder();
		deleteQuery.append("DELETE FROM ");
		deleteQuery.append(TABLE_NAME);
		deleteQuery.append(" WHERE ");
		deleteQuery.append(COL_1_ID).append(" = ?");
		return deleteQuery.toString();
	}
}