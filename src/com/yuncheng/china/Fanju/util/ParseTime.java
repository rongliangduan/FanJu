package com.china.yuncheng.fanju.util;

/**
 * Created by agonyice on 14-8-28.
 * 转换时间的类
 * 功能：时间转换毫秒数为  00:00格式
 */
public class ParseTime {
    public static String format(long time) {
        int ss = 1000;
        int ms = ss * 60;
        int hh = ms * 60;
        int dd = hh * 24;
        long day =ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / ms;
        long second = (ms - day * dd - hour * hh - minute * ms) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * ms - second * ss;

        String strDay = day < 10 ? "0" + day : "" + day;
        String strHour = hour < 10 ? "0" + hour : "" + hour;
        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSecond = second < 10 ? "0" + second : "" + second;
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
        return strMinute + ":" + strSecond;
    }
}
