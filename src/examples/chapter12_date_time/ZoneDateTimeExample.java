package examples.chapter12_date_time;

import java.time.*;

public class ZoneDateTimeExample {

    public void useZoneTime() {
        ZoneId zoneId = ZoneId.of("Europe/Rome");

        LocalDate date = LocalDate.of(2017, 10, 9);
        ZonedDateTime zdt1 = date.atStartOfDay(zoneId);
    }

    public void useOffSetDateTime() {
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        LocalDateTime localDateTime = LocalDateTime.of(2017, 10, 9, 10, 0, 0);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(localDateTime, newYorkOffset);

    }

}
