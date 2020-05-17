package com.rcp.kart.utils;

/**
 * 
 * Holds a utilities methods.
 *
 */
public class Utils {

	/**
	 * If true, the log messages are displayed, otherwise, log messages isn't
	 * displayed.
	 */
	private final static boolean DEBUG = false;

	/**
	 * Holds the tag to VIEW logs.
	 */
	public static final String VIEW = "VIEW";

	/**
	 * Holds the tag to PRESENTER logs.
	 */
	public static final String PRESENTER = "PRESENTER";

	/**
	 * Holds the tag to database logs.
	 */
	public static final String DATA_LOG = "DATABASE";
	
	/**
	 * Columns from race.db table.
	 */
	public static final String HOUR_COLUMN = "hour";
	public static final String ID_PILOT_COLUMN = "id_pilot";
	public static final String NAME_PILOT_COLUMN = "name_pilot";
	public static final String LAP_COLUMN = "lap";
	public static final String TIME_COLUMN = "time";
	public static final String SPEED_COLUMN = "speed";

	/**
	 * Utility method to print log messages.
	 * 
	 * @param tag
	 * @param message
	 */
	public static void Log(final String tag, final String message) {
		if (DEBUG) {
			System.out.println(tag + ": " + message);	
		}
	}
}
