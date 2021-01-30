package com.anand.task.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * ConsoleLog class is used for maintaining the Log Report.
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public class ConsoleLog {

	private static final Logger LOGGER = Logger.getLogger(ConsoleLog.class);
	static {
		// To skip all other logs (DEBUG logs will not print in logFile)
		Logger.getRootLogger().setLevel(Level.OFF);
	}

	/**
	 * ConsoleLog() is a private constructor to hide the implicit public one
	 */
	private ConsoleLog() {
		throw new IllegalStateException();
	}

	/**
	 * printErrorMessage method is used to log the error message
	 * 
	 * @param errorMessage
	 */
	public static void printErrorMessage(String errorMessage) {
		LOGGER.setLevel(Level.ERROR);
		LOGGER.error(errorMessage);
	}

	/**
	 * printLogMessage method is used to log the information message
	 * 
	 * @param logMsg
	 */
	public static void printLogMessage(String logMsg) {
		LOGGER.setLevel(Level.INFO);
		LOGGER.info(logMsg);
	}
}