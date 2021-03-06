package fr.raouf.kata.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    public String dateEnFrancaisLitteraire(Date input) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("EEEE d LLL u").toFormatter();
        System.out.println(formatter);
        return ZonedDateTime.ofInstant(input.toInstant(), ZoneId.systemDefault()).format(formatter);
    }

    public Date jeudiProchain(Date input) {
        return jourEn7(input, DayOfWeek.THURSDAY);
    }

    public Date jourEn7(Date input, DayOfWeek day) {
        ZonedDateTime date = ZonedDateTime.ofInstant(input.toInstant(), ZoneId.systemDefault()).with(TemporalAdjusters.next(day));
        return Date.from(date.toInstant());
    }

    public Date jourEn15(Date instance, DayOfWeek day) {
        return jourEn7(jourEn7(instance,day),day);
    }

    private enum LocalDate2Date implements Function<LocalDate, Date> {
        INSTANCE;

        @Override
        public Date apply(LocalDate input) {
            return Date.from(input.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }
}
