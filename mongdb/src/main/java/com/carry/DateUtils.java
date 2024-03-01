package com.carry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 * <p>
 * DateUtils
 *
 * @program: 
 * @description:
 * @author: Mr.Nanke
 * @create: 2022-05-25 19:16
 **/
public class DateUtils {
    /** * mongo 日期查询isodate * @param dateStr * @return */
    public static Date dateToISODate(String dateStr){

        //T代表后面跟着时间，Z代表UTC统一时间
        Date date = formatD(dateStr);
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
        String isoDate = format.format(date);
        try {
            return format.parse(isoDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date formatD(String dateStr){
        return formatD(dateStr,DATE_TIME_PATTERN);
    }

    public static Date formatD(String dateStr ,String format)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date ret = null ;
        try {
            ret = simpleDateFormat.parse(dateStr) ;
        } catch (ParseException e) {
            //
        }
        return ret;
    }

    public static void main(String[] args) {
        Date date = formatD("2022-04-11 12:00:00");
        System.out.println(date);

        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateStartTime = zonedDateTime.minusHours(24);
        System.out.println(zonedDateTime.toLocalDate());
    }
}
