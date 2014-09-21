package fr.raouf.kata.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.function.Function;

/**
 * Created by raphael on 20/09/14.
 */
public class DateCheckup {

    public Date instance(int day, int month, int year) {
        return LocalDate2Date.INSTANCE.apply(LocalDate.of(year, month, day));
    }

    public Date jeudiProchain(Date input) {
        LocalDate date = LocalDate.from(input.toInstant()).with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        return LocalDate2Date.INSTANCE.apply(date);
    }

    public String dateEnFrancais(Date input) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("E d mu").toFormatter();
        return formatter.format(input.toInstant());
    }

    private enum LocalDate2Date implements Function<LocalDate, Date> {
        INSTANCE;

        @Override
        public Date apply(LocalDate input) {
            return Date.from(input.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }
}
