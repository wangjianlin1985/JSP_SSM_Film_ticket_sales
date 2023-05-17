// 
// 
// 

package com.util;

import java.text.ParseException;
import java.util.Locale;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

public class VeDate
{
    public static double getDouble(final double num) {
        final DecimalFormat df2 = new DecimalFormat("#.00");
        return Double.parseDouble(df2.format(num));
    }
    
    public static String getStringDouble(final double num) {
        final DecimalFormat df2 = new DecimalFormat("#.00");
        return df2.format(num);
    }
    
    public static Date getNowDate() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateString = formatter.format(currentTime);
        final ParsePosition pos = new ParsePosition(8);
        final Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }
    
    public static Date getNowDateShort() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final String dateString = formatter.format(currentTime);
        final ParsePosition pos = new ParsePosition(8);
        final Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }
    
    public static String getStringDate() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getStringDatex() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getStringId() {
        final Random rand = new Random();
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        final String dateString = formatter.format(currentTime);
        return String.valueOf(dateString) + (rand.nextInt(900) + 100);
    }
    
    public static String getStringDateShort() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getStringTimeShort() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getYear() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getTimeShort() {
        final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        final Date currentTime = new Date();
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static Date strToDateLong(final String strDate) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final ParsePosition pos = new ParsePosition(0);
        final Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    
    public static String dateToStrLong(final Date dateDate) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateString = formatter.format(dateDate);
        return dateString;
    }
    
    public static String dateToStr(final Date dateDate) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final String dateString = formatter.format(dateDate);
        return dateString;
    }
    
    public static Date strToDate(final String strDate) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final ParsePosition pos = new ParsePosition(0);
        final Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    
    public static Date getNow() {
        final Date currentTime = new Date();
        return currentTime;
    }
    
    public static Date getLastDate(final long day) {
        final Date date = new Date();
        final long date_3_hm = date.getTime() - 122400000L * day;
        final Date date_3_hm_date = new Date(date_3_hm);
        return date_3_hm_date;
    }
    
    public static String getStringToday() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getHour() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateString = formatter.format(currentTime);
        final String hour = dateString.substring(11, 13);
        return hour;
    }
    
    public static String getTime() {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateString = formatter.format(currentTime);
        final String min = dateString.substring(14, 16);
        return min;
    }
    
    public static String getUserDate(final String sformat) {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        final String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getTwoHour(final String st1, final String st2) {
        String[] kk = null;
        String[] jj = null;
        kk = st1.split(":");
        jj = st2.split(":");
        if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0])) {
            return "0";
        }
        final double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60.0;
        final double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60.0;
        if (y - u > 0.0) {
            return new StringBuilder(String.valueOf(y - u)).toString();
        }
        return "0";
    }
    
    public static String getTwoDay(final String sj1, final String sj2) {
        final SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0L;
        try {
            final Date date = myFormatter.parse(sj1);
            final Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / 86400000L;
        }
        catch (Exception e) {
            return "";
        }
        return new StringBuilder(String.valueOf(day)).toString();
    }
    
    public static String getPreTime(final String sj1, final String jj) {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            final Date date1 = format.parse(sj1);
            final long Time = date1.getTime() / 1000L + Integer.parseInt(jj) * 60;
            date1.setTime(Time * 1000L);
            mydate1 = format.format(date1);
        }
        catch (Exception ex) {}
        return mydate1;
    }
    
    public static String getNextDay(final String nowdate, final String delay) {
        try {
            final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            final Date d = strToDate(nowdate);
            final long myTime = d.getTime() / 1000L + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000L);
            mdate = format.format(d);
            return mdate;
        }
        catch (Exception e) {
            return "";
        }
    }
    
    public static boolean isLeapYear(final String ddate) {
        final Date d = strToDate(ddate);
        final GregorianCalendar gc = (GregorianCalendar)Calendar.getInstance();
        gc.setTime(d);
        final int year = gc.get(1);
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    
    public static String getEDate(final String str) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final ParsePosition pos = new ParsePosition(0);
        final Date strtodate = formatter.parse(str, pos);
        final String j = strtodate.toString();
        final String[] k = j.split(" ");
        return String.valueOf(k[2]) + k[1].toUpperCase() + k[5].substring(2, 4);
    }
    
    public static String getEndDateOfMonth(final String dat) {
        String str = dat.substring(0, 8);
        final String month = dat.substring(5, 7);
        final int mon = Integer.parseInt(month);
        if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
            str = String.valueOf(str) + "31";
        }
        else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
            str = String.valueOf(str) + "30";
        }
        else if (isLeapYear(dat)) {
            str = String.valueOf(str) + "29";
        }
        else {
            str = String.valueOf(str) + "28";
        }
        return str;
    }
    
    public static boolean isSameWeekDates(final Date date1, final Date date2) {
        final Calendar cal1 = Calendar.getInstance();
        final Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        final int subYear = cal1.get(1) - cal2.get(1);
        if (subYear == 0) {
            if (cal1.get(3) == cal2.get(3)) {
                return true;
            }
        }
        else if (1 == subYear && 11 == cal2.get(2)) {
            if (cal1.get(3) == cal2.get(3)) {
                return true;
            }
        }
        else if (-1 == subYear && 11 == cal1.get(2) && cal1.get(3) == cal2.get(3)) {
            return true;
        }
        return false;
    }
    
    public static String getSeqWeek() {
        final Calendar c = Calendar.getInstance(Locale.CHINA);
        String week = Integer.toString(c.get(3));
        if (week.length() == 1) {
            week = "0" + week;
        }
        final String year = Integer.toString(c.get(1));
        return String.valueOf(year) + week;
    }
    
    public static String getWeek(final String sdate, final String num) {
        final Date dd = strToDate(sdate);
        final Calendar c = Calendar.getInstance();
        c.setTime(dd);
        if (num.equals("1")) {
            c.set(7, 2);
        }
        else if (num.equals("2")) {
            c.set(7, 3);
        }
        else if (num.equals("3")) {
            c.set(7, 4);
        }
        else if (num.equals("4")) {
            c.set(7, 5);
        }
        else if (num.equals("5")) {
            c.set(7, 6);
        }
        else if (num.equals("6")) {
            c.set(7, 7);
        }
        else if (num.equals("0")) {
            c.set(7, 1);
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }
    
    public static String getWeek(final String sdate) {
        final Date date = strToDate(sdate);
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }
    
    public static long getDays(final String date1, final String date2) {
        if (date1 == null || date1.equals("")) {
            return 0L;
        }
        if (date2 == null || date2.equals("")) {
            return 0L;
        }
        final SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = null;
        Date mydate = null;
        try {
            date3 = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        }
        catch (Exception ex) {}
        final long day = (date3.getTime() - mydate.getTime()) / 86400000L;
        return day;
    }
    
    public static String getNowMonth(String sdate) {
        sdate = String.valueOf(sdate.substring(0, 8)) + "01";
        final Date date = strToDate(sdate);
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        final int u = c.get(7);
        final String newday = getNextDay(sdate, new StringBuilder(String.valueOf(1 - u)).toString());
        return newday;
    }
    
    public static String getNo(final int k) {
        return String.valueOf(getUserDate("yyyyMMddhhmmss")) + getRandom(k);
    }
    
    public static String getRandom(final int i) {
        final Random jjj = new Random();
        if (i == 0) {
            return "";
        }
        String jj = "";
        for (int k = 0; k < i; ++k) {
            jj = String.valueOf(jj) + jjj.nextInt(9);
        }
        return jj;
    }
    
    public static boolean RightDate(final String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (date == null) {
            return false;
        }
        if (date.length() > 10) {
            sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        else {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            sdf.parse(date);
        }
        catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
