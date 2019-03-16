
package restock.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberUtils {

	private NumberUtils() {

	}


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


	public static boolean esNIE(final String identificacio) {
		boolean esNIE = false;
		if ((identificacio != null) && (identificacio.length() == 9) &&
				("XYZ".indexOf(Character.toUpperCase(identificacio.charAt(0))) != -1)) {
			esNIE = true;
		}
		return esNIE;
	}
	
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
