package com.sunilOS.ORSProject3.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The utility class which format the data one to another
 * @author Rishabh Gurjar
 * 
 *  
 */



public class DataUtility {

	
	public static final String APP_DATE_FORMAT = "yyyy-MM-dd";

	public static final String APP_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	
	public static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);

	 
	 
	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	
	public static String getStringData(Object val) {
		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	
	public static int getInt(String val) {
		if (DataValidator.isLong(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	
	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return (long) 0;
		}
	}

	
	public static Date getStringToDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {

		}
		return date;
	}

	
	public static String getDateToString(Date date) {
		try {
			return formatter.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	
	public static Date getDate(Date date, int day) {
		return null;
	}

	
	public static Timestamp getTimestamp(String val) {

		Timestamp ts = null;
		try {
			ts = new Timestamp((timeFormatter.parse(val)).getTime());
		} catch (Exception e) {
			return null;
		}
		return ts;
	}

	
	public static Timestamp getTimestamp(long l) {

		Timestamp ts = null;
		try {
			ts = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return ts;
	}

	
	public static Timestamp getCurrentTimestamp() {
		Timestamp ts = null;
		try {
			ts = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return ts;

	}

	
	public static long getTimestamp(Timestamp t) {
		try {
			return t.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {
//	        System.out.println("DU(main)"+getInt("124"));
	}

}
