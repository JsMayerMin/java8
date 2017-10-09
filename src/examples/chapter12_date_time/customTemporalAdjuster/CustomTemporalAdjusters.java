package examples.chapter12_date_time.customTemporalAdjuster;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class CustomTemporalAdjusters {

    public static TemporalAdjuster nextWorkingDay() {
        return TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if(dow == DayOfWeek.FRIDAY)
                dayToAdd = 2;
            else if (dow == DayOfWeek.SATURDAY)
                dayToAdd = 3;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
    }

}
