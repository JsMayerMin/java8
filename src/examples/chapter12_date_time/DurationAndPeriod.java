package examples.chapter12_date_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationAndPeriod {

    public static void useDurationClass() {

        LocalDateTime localDateTime1 = LocalDateTime.MIN;
        LocalDateTime localDateTime2 = LocalDateTime.MAX;

        LocalTime localTime1 = LocalTime.MIN;
        LocalTime localTime2 = LocalTime.MIDNIGHT;
        LocalTime localTime3 = LocalTime.MAX;

        Instant instant1 = Instant.MIN;
        Instant instant2 = Instant.MAX;

        Duration d1 = Duration.between(localDateTime1, localDateTime2);
        Duration d2 = Duration.between(localTime1, localTime2);
        Duration d3 = Duration.between(instant1, instant2);

        LocalDate localDate1 = LocalDate.MIN;
        LocalDate localDate2 = LocalDate.MAX;

        Period p1 = Period.between(localDate1, localDate2);

        Duration threeMinutes1 = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period threeWeeks2 = Period.of(3,1,0);

    }

}
