
package restock.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DataUtils {

	private DataUtils() {

	}

	/**
	 * Convertir timestamp A date.
	 *
	 * @param timestamp
	 *            un/a timestamp
	 * @return un date
	 */
	public static Date convertirTimestampADate(final Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	/**
	 * Agafa el valor de long from format date.
	 *
	 * @param date
	 *            un/a date
	 * @param format
	 *            un/a format
	 * @return un long from format date
	 */
	public static long getLongFromFormatDate(final LocalDateTime date, final String format) {
		return new Long(getFormatDateFromDate(date, format)).longValue();
	}

	/**
	 * Agafa el valor de format date from timestamp. 
	 *
	 * @param timestamp
	 *            un/a timestamp
	 * @param format
	 *            un/a format
	 * @return un format date from timestamp
	 */
	public static String getFormatDateFromTimestamp(final Timestamp timestamp, final String format) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		final SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
		return simpleFormat.format(cal.getTime());
	}

	/**
	 * Agafa el valor de format date from date. 
	 *
	 * @param localDateTime
	 *            un/a date
	 * @param format
	 *            un/a format
	 * @return un format date from date
	 */
	public static String getFormatDateFromDate(final LocalDateTime localDateTime, final String format) {
		final Calendar cal = Calendar.getInstance();
		final Date date = convertirLocalDateToUtilDate(localDateTime.toLocalDate());
		cal.setTimeInMillis(date.getTime());
		final SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
		return simpleFormat.format(cal.getTime());
	}

	/**
	 * Agafa el valor de month from date. 
	 *
	 * @param date
	 *            un/a date
	 * @return un month from date
	 */
	public static int getMonthFromDate(final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * Agafa el valor de date from format string.
	 *
	 * @param date
	 *            un/a date
	 * @param format
	 *            un/a format
	 * @return un date from format string
	 */
	public static Date getDateFromFormatString(final String date, final String format) {
		final DateFormat fmt = new SimpleDateFormat(format);
		try {
			return fmt.parse(date);
		} catch (final ParseException e) {
			return null;
		}
	}

	/**
	 * Agafa el valor de today with format.
	 *
	 * @param format
	 *            un/a format
	 * @return un today with format
	 */
	public static String getTodayWithFormat(final String format) {
		final Calendar cal = Calendar.getInstance();
		final SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
		return simpleFormat.format(cal.getTime());
	}

	/**
	 * Agafa el valor de year from date. 
	 *
	 * @param date
	 *            un/a date
	 * @return un year from date
	 */
	public static int getYearFromDate(final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Agafa el valor de first date.
	 *
	 * @param year
	 *            un/a year
	 * @param month
	 *            un/a month
	 * @return un first date
	 */
	public static LocalDateTime getFirstDate(final int year, final int month) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return convertirDateToLocalDate(calendar.getTime()).atStartOfDay();
	}

	/**
	 * Agafa el valor de last date. 
	 *
	 * @param year
	 *            un/a year
	 * @param month
	 *            un/a month
	 * @return un last date
	 */
	public static LocalDateTime getLastDate(final int year, final int month) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return convertirDateToLocalDate(calendar.getTime()).atStartOfDay();
	}

	/**
	 * Next month from date. 
	 *
	 * @param date
	 *            un/a date
	 * @return un date
	 */
	public static Date nextMonthFromDate(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, +1);
		return calendar.getTime();
	}


	/**
	 * convertim un Calendar a un LocalDateTime
	 *
	 * @param calendar
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(final Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		final TimeZone tz = calendar.getTimeZone();
		final ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		return LocalDateTime.ofInstant(calendar.toInstant(), zid);
	}

	/**
	 * Convertim una data de tipus LocalDate a tipus Date
	 *
	 * @param localDate
	 * @return Date
	 */
	public static Date convertirLocalDateToUtilDate(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Convertim una data de tipus Date a tipus LocalDate
	 *
	 * @param date
	 * @return LocaDate
	 */
	public static LocalDate convertirDateToLocalDate(final Date date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.US);
		final GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		if (month.length() == 1) {
			month = "0" + month;
		}

		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		if (day.length() == 1) {
			day = "0" + day;
		}

		final String dateString = cal.get(Calendar.YEAR) + "-" + month + "-" + day;
		final LocalDate localDate = LocalDate.parse(dateString, formatter);

		return localDate;
	}

	/**
	 * convertim un objecte <i>java.util.Date</i> al tipus <i>java.time.LocalDateTime</i>
	 *
	 * @param dateToConvert
	 * @return
	 */
	public LocalDateTime convertToLocalDateTimeViaInstant(final Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
	}


}
