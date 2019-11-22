package utils;

import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

    public DateUtils() {

	};

    public String getToday() {
		Date today = new Date(Calendar.getInstance().getTime().getTime());

		Pattern patternDate = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
		Matcher matchDate= patternDate.matcher(today.toString());
		matchDate.find();

		String strToday = matchDate.group(3) + "/" + matchDate.group(2) + "/" + matchDate.group(1);

		return strToday;
	}

}
