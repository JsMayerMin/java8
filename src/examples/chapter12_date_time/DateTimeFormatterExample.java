package examples.chapter12_date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateTimeFormatterExample {

    public void useDateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2017, 10, 9);
        String formattedDate = date1.format(dateTimeFormatter);
        LocalDate date2 = LocalDate.parse(formattedDate, dateTimeFormatter);

    }

    public void useZonedDateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.KOREA);
        LocalDate date1 = LocalDate.of(2017, 10, 9);
        String formattedDate = date1.format(dateTimeFormatter);
        LocalDate date2 = LocalDate.parse(formattedDate, dateTimeFormatter);

    }

    public void useCustomDateTimeFormatter() {
        DateTimeFormatter customFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.YEAR)
                .appendLiteral(", ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(", ")
                .appendText(ChronoField.DAY_OF_MONTH)
                .toFormatter(Locale.KOREA);
    }

}
