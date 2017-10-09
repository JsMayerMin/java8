package examples.chapter12_date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TimeChangeExample {

    public static void changeLocalDate() {
        LocalDate date1 = LocalDate.of(2017, 10, 9);
        LocalDate date2 = date1.withYear(2016);
        LocalDate date3 = date2.withDayOfMonth(3);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        LocalDate date5 = date1.plusWeeks(Period.ofWeeks(3).get(ChronoUnit.WEEKS));
    }

    public static void useTemporalAdjusters() {

        LocalDate date1 = LocalDate.of(2017, 10, 9);
        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)); //마주하는 일요일
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth()); //해당 달 마지막일

    }

}
