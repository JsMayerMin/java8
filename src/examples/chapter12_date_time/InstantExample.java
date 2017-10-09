package examples.chapter12_date_time;

import java.time.Instant;

public class InstantExample {

    public static void useInstantClass() {
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);

        // 아래의 코드는 UnsupportedTemporalTypeException을 발생시킨다.
        // int year = Instant.now().get(ChronoField.YEAR);
    }

}
