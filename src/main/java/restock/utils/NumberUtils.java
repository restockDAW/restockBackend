/*
 * 
 * Albert Codina
 */

package restock.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * The Class NumberUtils.
 */
public class NumberUtils {

	/**
	 * Number utils.
	 */
	private NumberUtils() {

	}


	/**
	 * Price format.
	 *
	 * @param value the value
	 * @return string
	 */
	public static String priceFormat(final Double value) {
		if (value != 0) {
			final DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
			otherSymbols.setDecimalSeparator(',');
			otherSymbols.setGroupingSeparator('.');
			final DecimalFormat df = new DecimalFormat("#,##0.00", otherSymbols);
			return df.format(value);
		} else {
			return String.valueOf(value);
		}
	}


	/**
	 * Es NIE.
	 *
	 * @param identificacio the identificacio
	 * @return true, if successful
	 */
	public static boolean esNIE(final String identificacio) {
		boolean esNIE = false;
		if ((identificacio != null) && (identificacio.length() == 9) &&
				("XYZ".indexOf(Character.toUpperCase(identificacio.charAt(0))) != -1)) {
			esNIE = true;
		}
		return esNIE;
	}
	
	/**
	 * Checks if is number.
	 *
	 * @param string the string
	 * @return true, if is number
	 */
	public static boolean isNumber(final String string) {
		if ((string == null) || string.isEmpty()) {
			return false;
		}

		int i = 0;
		if (string.charAt(0) == '-') {
			if (string.length() > 1) {
				i++;
			} else {
				return false;
			}
		}

		for (; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
