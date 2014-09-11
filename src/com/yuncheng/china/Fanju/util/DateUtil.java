package com.yuncheng.china.Fanju.util;



import com.lidroid.xutils.util.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class DateUtil
{
    public static final String DEFAULT_YEAR_PATTERN = "yyyy";
    public static final String DEFAULT_MONTH_PATTERN = "yyyy-MM";
    public static final String DEFAULT_DAY_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public static final String DEFAULT_DATE_TIME_PATTERN = DEFAULT_DAY_PATTERN + " " + DEFAULT_TIME_PATTERN;
    public static final String DEFAULT_DATE_TIME_MILLI_PATTERN = DEFAULT_DATE_TIME_PATTERN + " SSS";

    public static final long ONE_SECONDS = 1000L;
    public static final long ONE_MINUTE = ONE_SECONDS * 60;
    public static final long ONE_HOUR = ONE_MINUTE * 60;
    public static final long ONE_DAY = ONE_HOUR * 24;
    public static final long ONE_WEEK = ONE_DAY * 7;

    public static long todayStart()
    {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTimeInMillis();
    }

    public static long todayEnd()
    {
        return todayStart() + ONE_DAY - 1;
    }

    public static long birthday(int year, int month, int day)
    {
        Calendar birthday = Calendar.getInstance();
        birthday.clear();
        birthday.set(Calendar.YEAR, year);
        birthday.set(Calendar.MONTH, month - 1);
        birthday.set(Calendar.DAY_OF_MONTH, day);
        return birthday.getTimeInMillis();
    }

    public static long birthday(int age)
    {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, birthday.get(Calendar.YEAR) - age);
        return birthday.getTimeInMillis();
    }

    public static int age(long birthday)
    {
        Calendar now = Calendar.getInstance();
        Calendar birthdayDate = Calendar.getInstance();
        birthdayDate.setTimeInMillis(birthday);
        int diffYear = now.get(Calendar.YEAR) - birthdayDate.get(Calendar.YEAR);
        int diffMonth = now.get(Calendar.MONTH) - birthdayDate.get(Calendar.MONTH);
        int diffDay = now.get(Calendar.DATE) - birthdayDate.get(Calendar.DATE);
        return diffYear + (diffMonth > 0 ? 1 : diffDay >= 0 ? 1 : 0);
    }

    public static boolean isBirthday(long birthday)
    {
        Calendar now = Calendar.getInstance();
        Calendar birthdayDate = new GregorianCalendar();
        birthdayDate.setTimeInMillis(birthday);
        return now.get(Calendar.DAY_OF_YEAR) == birthdayDate.get(Calendar.DAY_OF_YEAR);
    }

    public static String format(long dateTime)
    {
        return format(new Date(dateTime));
    }

    public static String format(long dateTime, String pattern)
    {
        return format(new Date(dateTime), pattern);
    }

    public static String format(Date date)
    {
        return format(date, DEFAULT_DATE_TIME_MILLI_PATTERN);
    }

    public static String format(String pattern)
    {
        return format(new Date(), pattern);
    }

    public static String format(Date date, String pattern)
    {
        if (date == null || pattern == null)
        {
            LogUtils.w("date or pattern is null. date:" + date + ", pattern:" + pattern);
            return "";
        }
        try
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        } catch (RuntimeException e)
        {
            LogUtils.w("format date '" + date + "' with pattern '" + pattern + "' failure.", e);
            return "";
        }
    }

    public static Date parse(String value)
    {
        return parse(value, DEFAULT_DATE_TIME_PATTERN);
    }

    public static Date parse(String value, String pattern)
    {
        if (value == null || pattern == null)
        {
            LogUtils.w("value or pattern is null. value:" + value + ", pattern:" + pattern);
            return null;
        }
        try
        {
            return new SimpleDateFormat(pattern).parse(value);
        } catch (Throwable e)
        {
            return null;
        }
    }

    public static boolean isDate(String value)
    {
        return isDate(value, DEFAULT_DATE_TIME_PATTERN);
    }

    public static boolean isDate(String value, String pattern)
    {
        try
        {
            return new SimpleDateFormat(pattern).parse(value) != null;
        } catch (Throwable e)
        {
            LogUtils.d("[value:" + value + ", pattern:" + pattern + "] is not date.", e);
            return false;
        }
    }

    public static boolean sameDay(long time)
    {
        return format(System.currentTimeMillis(), DEFAULT_DAY_PATTERN)
                .equals(format(time, DEFAULT_DAY_PATTERN));
    }

    private static boolean sameWeek(long time)
    {
        Calendar nowCalendar = Calendar.getInstance();
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTimeInMillis(time);
        return nowCalendar.get(Calendar.YEAR) == timeCalendar.get(Calendar.YEAR)
                && nowCalendar.get(Calendar.WEEK_OF_YEAR) == timeCalendar.get(Calendar.WEEK_OF_YEAR);
    }


   /* public static String show(long time)
    {
        if (sameDay(time))
        {
            return format(time, DEFAULT_TIME_PATTERN);
        }
        if (!sameWeek(time))
        {
            return format(time, DEFAULT_DAY_PATTERN);
        }
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTimeInMillis(time);
        return ResourcesHelper.getStringArray(R.array.ui_week)[timeCalendar.get(Calendar.DAY_OF_WEEK) - 1];
    }*/


}
