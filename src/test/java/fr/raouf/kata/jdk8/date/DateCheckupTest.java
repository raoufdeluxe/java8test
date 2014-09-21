package fr.raouf.kata.jdk8.date;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;

public class DateCheckupTest {

    DateCheckup dateCheckup;

    @BeforeClass
    public void init() {
        dateCheckup = new DateCheckup();
    }

    @Test
    public void should_return_a_date_from_day_mont_and_year() {
        // GIVEN
        Instant expected = LocalDate.of(1981, 2, 17).atStartOfDay(ZoneId.systemDefault()).toInstant();
        // WHEN
        Instant date = dateCheckup.instance(17, 2, 1981).toInstant();

        // THEN
        assertEquals(expected, date);
    }

    @Test
    public void should_return_date_like_day_dd_mm_yyyy() {

    }

    @Test
    public void should_return_next_thursday() {

    }
}