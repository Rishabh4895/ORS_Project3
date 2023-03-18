package com.sunilOS.ORSProject3.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * the class which validate input data enter by user
 * 
 * @author Rishabh Gurjar
 *
 */


public class DataValidator {

	
	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	
	public static boolean isRollNo(String val) {

		String pwd = "[0-9]+[a-zA-Z_]+[0-9]+";

		if (isNotNull(val)) {
			try {
				return val.matches(pwd);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	public static boolean isDOB(String val) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(todayDate);
		cal.add(Calendar.YEAR, -17);

		Date beforedate = cal.getTime();
		if (beforedate.compareTo(userDate) == -1) {
			return false;
		} else {
			return true;
		}
	}

	
	// [a-zA-z0-9]*([,.0-9\\s]+[a-zA-Z0-9]*)*
	public static boolean isCollege(String val) {
		String ch = "[a-zA-z0-9]*([,.0-9\\s]+[a-zA-Z0-9]*)*";
		if (isNotNull(val)) {
			try {
				return val.matches(ch);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	// old regex ([a-zA-Z]+(?:.|-| |'))*[a-zA-Z]*
	public static boolean isState(String val) {
		String reg = "([a-zA-Z])*[m.p][a-zA-Z]*";
		// [7-9][0-9]{9}$
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	
	public static boolean isNameWithSpace(String val) {
		String name = "[a-zA-Z ]*";
		if (isNotNull(val)) {
			try {
				return val.matches(name);

			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isCity(String val) {
		String reg = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";

		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	

	// old regex for name [a-zA-z]*([,.\\s]+[a-z]*)*
	public static boolean isName(String val) {
		String reg = "[a-zA-Z]";
		if (isNotNull(val)) {
			try {
				return val.matches(reg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	public static boolean isWhiteSpace(String val) {
		if (val.matches(".*\\s+.*")) {
			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isSpecial(String val) {
		String reg = "[A-Za-z0-9\\s]*";

		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	
	public static boolean isNumber(String val) {
		String reg = "[A-Za-z ~!@#$%^&*_=-|?/><.,]*";
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	
	public static boolean isMob(String val) {

		String mo = "^[7-9][0-9]{9}$";

		if (val.matches(mo)) {
			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isPassword(String val) {

		// String pwd = "^[a-zA-Z0-9!@#$%^&*]{6,12}$";
		String pwd = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15})";
		if (isNotNull(val)) {
			try {
				return val.matches(pwd);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	public static boolean isPasslength(String val) {

		if (isNotNull(val)) {
			if (val.length() > 5 && val.length() <= 12) {
				return true;
			}

		}
		return false;
	}

	

	public static boolean isInteger(String val) {
		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	public static boolean isLong(String val) {
		if (isNotNull(val)) {
			try {
				long i = Long.parseLong(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	public static boolean isEmail(String val) {

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(val)) {
			try {
				return val.matches(emailreg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	
	public static boolean isDate(String val) {

		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getStringToDate(val);
		}
		return d != null;
	}

	
	public static boolean isExamDate(String val) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		if (userDate.compareTo(todayDate) == -1) {
			return true;
		} else {
			return false;
		}
	}

	

	public static boolean isCourse(String val) {

		// String mo = "^[a-zA-Zs.\\s]+$";

		String mo = "([a-zA-Z]+(\\.| |))*[a-zA-Z]*";

		if (val.matches(mo)) {

			return true;

		}

		else {

			return false;

		}

	}

	
	public static boolean isSubject(String val) {

		String sub = "^[.a-zA-Z\\s]+[\\s+a-zA-Z.+#&/]{0,3}+$";
		if (val.matches(sub)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean test(String val) {
		String test = "([a-zA-Z]+(\\.| |))*[0-9]*";
		if (val.matches(test)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isPhoneNo(String val) {
		boolean pass = true;
		if (isNotNull(val)) {
			try {
				long l = DataUtility.getLong(val);
				pass = true;
			} catch (NumberFormatException e) {
				pass = false;
			}
		} else {
			pass = false;
		}
		if (val.length() != 10) {
			pass = false;
		}
		return pass;
	}

	public static boolean isName2(String val) {

		String name = "[a-zA-Z][a-zA-Z ]+";

		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isPhone(String val) {
		Boolean flag = false;
		if (val.charAt(0) - 48 > 6) {
			flag = true;
		}
		return flag;
	}

	public static boolean isSunday(Date examdate) {
		boolean flag = false;
		int day = examdate.getDate();
		if (day == 0) {
			flag = true;
		}
		return flag;
	}

	public static boolean numberValid() {
		int number = 0;
		if (number <= 0 || number >= 100) {

			return true;

		} else {
			return false;
		}

	}

	
	public static void main(String[] args) {
		System.out.println(isPassword("String"));

		/*
		 * System.out.println("Not Null 2" + isNotNull("ABC"));
		 * System.out.println("Not Null 3" + isNotNull(null));
		 * System.out.println("Not Null 4" + isNull("123"));
		 * 
		 * System.out.println("Is Int " + isInteger(null)); System.out.println(
		 * "Is Int " + isInteger("ABC1")); System.out.println("Is Int " +
		 * isInteger("123")); System.out.println("Is Int " + isNotNull("123"));
		 */
		// System.out.println(isLong("7878787878"));
	}

	public static boolean isFutureDate(String val) {
		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getStringToDate(val);
		}
		return d != null;

	}

	public static boolean ageLimit(String val) {

		boolean pass = false;
		if (isDate(val)) {
			Date cdate = new Date();
			try {
				Date userdate = DataUtility.formatter.parse(val);
				int age = cdate.getYear() - userdate.getYear();
				System.out.println("final age  " + age);
				if (age >= 18 && age <= 60) {
					pass = true;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return pass;
	}

	public static boolean isValidPasswordLenth(String val) {

		if (isNotNull(val)) {
			if (val.length() > 6 && val.length() < 12)
				return true;
		}
		return false;
	}
}