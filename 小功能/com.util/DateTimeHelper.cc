package com.midea.logistics.common.mobile.helper;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * ©Copyright ©1968-2018 Midea Group,IT
 * @author EX_XIANGJIXJ
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
public final class DateTimeHelper {
    public static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HHmmss");
    public static final DateTimeFormatter FORMATTER_TIME_HH_MM_SS = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter FORMATTER_YEAR_MONTH = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter FORMATTER_SHORT_DATE = DateTimeFormatter.ofPattern("yyMMdd");
    public static final DateTimeFormatter FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter FORMATTER_SHORT_DATETIME = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    public static final DateTimeFormatter FORMATTER_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter FORMATTER_LONG_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private DateTimeHelper() {
        throw new UnsupportedOperationException("create private ");
    }
    /**
     * localDateTime plusDays  Date
     * @param localDateTime localDateTime
     * @param num           num
     * @return Date
     */
    public static Date plusDays(LocalDateTime localDateTime, Long num) {
        return transformToDate(localDateTime.plusDays(num));
    }
    /**
     * localDateTime plusYears  Date
     * @param localDateTime localDateTime
     * @param num           num
     * @return Date
     */
    public static Date plusYears(LocalDateTime localDateTime, Long num) {
        return transformToDate(localDateTime.plusYears(num));
    }
    /**
     * localDateTime plusWeeks  Date
     * @param localDateTime localDateTime
     * @param num           num
     * @return Date
     */
    public static Date plusWeeks(LocalDateTime localDateTime, Long num) {
        return transformToDate(localDateTime.plusWeeks(num));
    }
    /**
     * localDateTime plusMonths  Date
     * @param localDateTime localDateTime
     * @param num           num
     * @return Date
     */
    public static Date plusMonths(LocalDateTime localDateTime, Long num) {
        return transformToDate(localDateTime.plusMonths(num));
    }

    /**
     * localDateTime plusDays  Date
     * @param date date
     * @param num           num
     * @return Date
     */
    public static Date plusDays(Date date, Long num) {
        return transformToDate(transformToLocalDateTime(date).plusDays(num));
    }
    /**
     * localDateTime plusYears  Date
     * @param date date
     * @param num           num
     * @return Date
     */
    public static Date plusYears(Date date, Long num) {
        return transformToDate(transformToLocalDateTime(date).plusYears(num));
    }
    /**
     * localDateTime plusWeeks  Date
     * @param date Date
     * @param num           num
     * @return Date
     */
    public static Date plusWeeks(Date date, Long num) {
        return transformToDate(transformToLocalDateTime(date).plusWeeks(num));
    }
    /**
     * localDateTime plusMonths  Date
     * @param date date
     * @param num           num
     * @return Date
     */
    public static Date plusMonths(Date date, Long num) {
        return transformToDate(transformToLocalDateTime(date).plusMonths(num));
    }

    /**
     * localDateTime plusHours  Date
     * @param localDateTime localDateTime
     * @param num           num
     * @return Date
     */
    public static Date plusHours(LocalDateTime localDateTime, Long num) {
        return transformToDate(localDateTime.plusHours(num));
    }

    /**
     * Date plusHours  Date
     * @param date date
     * @param num  num
     * @return Date
     */
    public static Date plusHours(Date date, Long num) {
        return transformToDate(transformToLocalDateTime(date).plusHours(num));
    }

    /**
     * localDateTime plusSeconds  LocalDateTime
     * @param localDateTime localDateTime
     * @param num           num
     * @return Date
     */
    public static Date plusSeconds(LocalDateTime localDateTime, Long num) {
        return transformToDate(localDateTime.plusSeconds(num));
    }

    /**
     * Date plusSeconds Date
     * @param date date
     * @param num  num
     * @return Date
     */
    public static Date plusSeconds(Date date, Long num) {
        return transformToDate(transformToLocalDateTime(date).plusSeconds(num));
    }

    /**
     * Date  plusHoursToLocalDateTime LocalDateTime
     * @param date date
     * @param num  num
     * @return LocalDateTime
     */
    public static LocalDateTime plusHoursToLocalDateTime(Date date, Long num) {
        return transformToLocalDateTime(date).plusHours(num);
    }

    /**
     * LocalDateTime  plusHoursToLocalDateTime LocalDateTime
     * @param date date
     * @param num  num
     * @return LocalDateTime
     */
    public static LocalDateTime plusHoursToLocalDateTime(LocalDateTime date, Long num) {
        return date.plusHours(num);
    }

    /**
     * LocalDateTime  plusSecondsLocalDateTime Date
     * @param date date
     * @param num  num
     * @return LocalDateTime
     */
    public static LocalDateTime plusSecondsLocalDateTime(Date date, Long num) {
        return transformToLocalDateTime(date).plusSeconds(num);
    }

    /**
     * @param date date
     * @param num  num
     * @return LocalDateTime
     */
    public static LocalDateTime plusSecondsLocalDateTime(LocalDateTime date, Long num) {
        return date.plusSeconds(num);
    }

    /**
     * LocalDateTime 日期之之间的秒
     * @param begin begin
     * @param end   end
     * @return Long
     */
    public static Long between(LocalDateTime begin, LocalDateTime end) {
        return Duration.between(begin.atZone(ZoneId.systemDefault()).toInstant(), end.atZone(ZoneId.systemDefault()).toInstant()).getSeconds();
    }

    /**
     * Date 日期之之间的秒
     * @param begin begin
     * @param end   end
     * @return Long
     */
    public static Long between(Date begin, Date end) {
        return Duration.between(begin.toInstant(), end.toInstant()).getSeconds();
    }

    /**
     * 判断时间是否在时间段内
     * @param confirmDataTime confirmDataTime
     * @param beginTime       beginTime
     * @param endTime         endTime
     * @return Boolean
     */
    public static Boolean belongCalendar(Date confirmDataTime, Date beginTime, Date endTime) {
        Boolean isBefore = DateTimeHelper.transformToLocalDateTime(confirmDataTime).isBefore(DateTimeHelper.transformToLocalDateTime(endTime));
        Boolean isAfter = DateTimeHelper.transformToLocalDateTime(confirmDataTime).isAfter(DateTimeHelper.transformToLocalDateTime(beginTime));
        return isBefore && isAfter;
    }

    /**
     * 判断时间是否在时间段内
     * @param confirmDataTime confirmDataTime
     * @param beginTime       beginTime
     * @param endTime         endTime
     * @return Boolean
     */
    public static Boolean belongCalendar(LocalDateTime confirmDataTime, LocalDateTime beginTime, LocalDateTime endTime) {
        Boolean isBefore = confirmDataTime.isBefore(endTime);
        Boolean isAfter = confirmDataTime.isAfter(beginTime);
        return isBefore && isAfter;
    }

    /**
     * 转换成 java.util.Date
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime
     * @param date date
     * @return LocalDateTime
     */
    public static LocalDateTime transformToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 当前一小时开始
     * @param localDateTimeData localDateTime
     * @return Date
     */
    public static Date transformToDateHourStart(LocalDateTime localDateTimeData) {
        LocalDateTime  localDateTime=localDateTimeData;
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
           localDateTime = LocalDateTime.of(year, month, day, hour, 0, 1);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 当周星期一开始
     * @param localDateTimeData localDateTime
     * @return Date Date
     */
    public static Date transformToDateWeekStart(LocalDateTime localDateTimeData) {
        LocalDateTime  localDateTime=localDateTimeData;
        TemporalField temporalField = WeekFields.of(Locale.PRC).dayOfWeek();
        LocalDate with = localDateTime.toLocalDate().with(temporalField, 2);
        int year = with.getYear();
        int month = with.getMonthValue();
        int day = with.getDayOfMonth();
        localDateTime = LocalDateTime.of(year, month, day, 0, 0, 1);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 当天开
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateDayStart(LocalDateTime localDateTime) {
        return Date.from(getLocalDateTime000001(localDateTime).atZone(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDateTime getLocalDateTime000001(LocalDateTime localDateTime) {
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }

    /**
     * 当天结束
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateDayEnd(LocalDateTime localDateTime) {
        return Date.from(getLocalDateTime235959(localDateTime).atZone(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDateTime getLocalDateTime235959(LocalDateTime localDateTime) {
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        return LocalDateTime.of(year, month, day, 23, 59, 59);
    }

    /**
     * 当天结束
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateWeekEnd(LocalDateTime localDateTime) {
        return Date.from(getLocalDateTime235959(localDateTime).plusDays(6L).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 当月开始
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateMonthStart(LocalDateTime localDateTime) {
        LocalDate localDateMonth = localDateTime.toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
        int year = localDateMonth.getYear();
        int month = localDateMonth.getMonthValue();
        int day = localDateMonth.getDayOfMonth();
        return Date.from(LocalDateTime.of(year, month, day, 0, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 当月开始
     * @param date date
     * @return Date
     */
    public static Date transformToDateMonthStart(Date date) {
        return transformToDateMonthStart(transformToLocalDateTime(date));
    }

    /**
     * 当天结束
     * @param date Date
     * @return Date
     */
    public static Date transformToDateWeekEnd(Date date) {
        return transformToDateWeekEnd(transformToLocalDateTime(date));
    }

    /**
     * 当天结束
     * @param date date
     * @return Date
     */
    public static Date transformToDateDayEnd(Date date) {
        return transformToDateDayEnd(transformToLocalDateTime(date));
    }

    /**
     * 当前一小时开始
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateHourStart(Date localDateTime) {
        return transformToDateHourStart(transformToLocalDateTime(localDateTime));
    }

    /**
     * 当前一小时结束
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateHourEnd(LocalDateTime localDateTime) {
        return transformToDate(plusSecondsLocalDateTime(transformToDateHourStart(localDateTime), 60 * 60 - 2L));
    }

    /**
     * 当前一小时结束
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date transformToDateHourEnd(Date localDateTime) {
        return transformToDate(plusSecondsLocalDateTime(transformToDateHourStart(localDateTime), 60 * 60 - 2L));
    }

    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static String formatDate(Date date) {
        return DateTimeHelper.FORMATTER_DATETIME.format(DateTimeHelper.transformToLocalDateTime(date));
    }
    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static Date parseDate(String date) {
        if(date==null||date.isEmpty()){
            return  null;
        }
        return transformToDate(LocalDateTime.parse(date,DateTimeHelper.FORMATTER_DATETIME));
    }

    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static String formatDate(LocalDateTime date) {
        return DateTimeHelper.FORMATTER_DATETIME.format(date);
    }

    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static String formatTime(LocalDateTime date) {
        return DateTimeHelper.FORMATTER_TIME_HH_MM_SS.format(date);
    }

    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static String formatTime(Date date) {
        return DateTimeHelper.FORMATTER_TIME_HH_MM_SS.format(DateTimeHelper.transformToLocalDateTime(date));
    }

    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static String format(Date date) {
        return DateTimeHelper.FORMATTER_DATETIME.format(DateTimeHelper.transformToLocalDateTime(date));
    }
    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static Date parse(String date) {
        return transformToDate(LocalDateTime.parse(date,DateTimeHelper.FORMATTER_DATETIME));
    }

    /**
     * 检查日期是否有效
     * @param date date
     * @return Boolean
     */
    public static Boolean checkDate(Date date) {
        if (date == null) {
            return false;
        }
        Calendar calendarTime = Calendar.getInstance();
        calendarTime.set(1970, 0, 0, 0, 0, 0);
        long timeInMillis = calendarTime.getTimeInMillis();
        return (date.getTime() - timeInMillis) > 0;
    }

    /**
     * 格式化时间
     * @param date date
     * @return String
     */
    public static String format(LocalDateTime date) {
        return DateTimeHelper.FORMATTER_DATETIME.format(date);
    }


}