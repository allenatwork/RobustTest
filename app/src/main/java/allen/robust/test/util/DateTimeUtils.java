package allen.robust.test.util;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by NTQ on 11/6/2015.
 */
public class DateTimeUtils {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd"; //2015-11-05

    public static Date stringToDate(String dateInString, String currentFormat) {
        if (TextUtils.isEmpty(dateInString)) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(currentFormat);
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date, String format) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        } else {
            cal.setTime(new Date());
        }
        return cal;
    }
}
