package examples.chapter12_date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class localDateExample {

    public static void useJavaTimePackage() {

        LocalDate date = LocalDate.of(2017,10,9);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        LocalDate today = LocalDate.now(); //시스템 시간을 이용한다.
        int year1 = today.get(ChronoField.YEAR);
        int month1 = today.get(ChronoField.MONTH_OF_YEAR);
        int day1 = today.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(10, 58, 0);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate parsedDate = LocalDate.parse("2017-10-09");
        LocalTime parsedTime = LocalTime.parse("11:02:59");

        LocalDateTime localDateTime = LocalDateTime.of(2017, Month.NOVEMBER, 9, 11, 3, 59);
        LocalDateTime localDateTime1 = time.atDate(today);
        LocalDateTime localDateTime2 = today.atTime(time);
        LocalDateTime localDateTime4 = today.atTime(11, 5, 12);
        LocalDateTime localDateTime3 = LocalDateTime.of(today, time);

        LocalDate localDate1 = localDateTime.toLocalDate();
        LocalTime localTime1 = localDateTime.toLocalTime();

        LocalDate parsedDateWithFormatter = LocalDate.parse("2017-10-09");  //TODO : 추가

    }

}
