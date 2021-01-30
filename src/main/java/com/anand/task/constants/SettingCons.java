package com.anand.task.constants;

/**
 * SettingCons is a constant class used for all FileShare setting inputs
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public class SettingCons {

	/**
	 * SettingCons() is a private constructor to hide the implicit public one
	 */
	private SettingCons() {
		throw new IllegalStateException();
	}

	public static final String TOOL_VERSION = "v1.0";
	public static final String TOOL_BUILD_NO = "B0001";
	public static final String TOOL_NAME = "Assessment";

	public static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
	public static final String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String CURRENT_DIR = System.getProperty("user.dir"); // RETURNS CURRENT DIRECTORY
	public static final String TEMP_DIR = System.getProperty("java.io.tmpdir"); // TEMP DIRECTORY

	public static final String LOG_DATE_PATTERN = "yyyy-MM-dd";
	public static final String LOG_FOLDER_PATH = CURRENT_DIR + "/Assessment_Logs/";
	public static final String LOG_PROPERTY_PATH = CURRENT_DIR + "/AdminProperty/Assessment_LogFormatter.properties";

	public static final String DEF_ENCODING = "UTF-8";
}