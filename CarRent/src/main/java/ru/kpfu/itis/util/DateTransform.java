package ru.kpfu.itis.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class DateTransform {
    public static GregorianCalendar transformDate(String date,String time){
        String[] t = time.split(":");
        int hours = Integer.parseInt(t[0]);
        int minutes = Integer.parseInt(t[1]);
        String[] d = date.split("-");
        int day = Integer.parseInt(d[0]);
        int mon = Integer.parseInt(d[1]);
        int year = Integer.parseInt(d[2]);

        return new GregorianCalendar(year,mon,day,hours,minutes);
    }
}
