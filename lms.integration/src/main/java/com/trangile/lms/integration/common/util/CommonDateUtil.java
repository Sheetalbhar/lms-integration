package com.trangile.lms.integration.common.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;



public class CommonDateUtil {
	public final static long SECOND_MILLIS = 1000;
	public final static long MINUTE_MILLIS = SECOND_MILLIS*60;
	public final static long HOUR_MILLIS = MINUTE_MILLIS*60;
	public final static long DAY_MILLIS = HOUR_MILLIS*24;
	public final static long YEAR_MILLIS = DAY_MILLIS*365;
	public final static String DATE_FORMAT_DATE_TIME_MILLIS = "yyyy-MM-dd HH:mm:ss.S";
	public final static String DATE_FORMAT_DATE_TIME_MILLIS_ALT = "dd/MM/yyyy HH:mm:ss";
	public final static String DATE_FORMAT_DATE_EXPIRY = "yyyy/MM/dd";
	public final static String DATE_FORMAT_SEARCH = "yyyy/MM/dd HH:mm:ss";
	public final static String DATE_FORMAT_SQL = "MM-dd-yyyy";
	public final static String DATE_FORMAT_STR = "MM/dd/yyyy";
	public final static String INVALID_DATE = "Invalid Date";
	public final static String UTC_FORMAT = " UTC %s%02d%s%02d";
	public final static String DATE_MID_NIGHT = " 23:59:59";
	public final static String DATE_EARLY_HOURS = " 00:00:00";
	public final static String ONLINE_DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	public final static String UI_DATE_FORMAT = "dd-MMM-yyyy";
	public final static String UI_DATE_TIME_FORMAT = "dd-MMM-yyyy HH:mm:ss";
	public final static String ES_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public final static String PLAZA_DATE_TIME_FORMAT = "EEEE, MMM dd, yyyy HH:mm a";

	
	public static Date stringToDate(final String stringDate, final String dateFormat)
			throws ParseException {
		final SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		return formatter.parse(stringDate);
	}
	
	public static String convertDateFormat(final String date, final String fromDateFormat,
			final String toDateFormat) throws ParseException {
		final SimpleDateFormat fromDateFormatter = new SimpleDateFormat(
				fromDateFormat);
		final Date fromDate = fromDateFormatter.parse(date);

		final SimpleDateFormat toDateFormatter = new SimpleDateFormat(toDateFormat);
		return toDateFormatter.format(fromDate);
	}
	
	public static String dateToString(final Date date, final String dateFormat) {
		final SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(date);
	}
	
	public static String getCurrentDateString(final String dateFormat) {
		final SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(new Date());
	}
	
	public static String getCurrentTimeString(final String timeFormat) {
		final SimpleDateFormat formatter = new SimpleDateFormat(timeFormat);
		final Calendar calInstance = Calendar.getInstance();
		return formatter.format(calInstance.getTime());
	}

	public static Date convertIntToDate(final Integer dateFormat) {
//		Date date = new Date(19000101L);
//		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy", );
//		
		return null;
	}
}
