package fr.raouf.kata.jdk8.date;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateCheckupTest {

    DateCheckup dateCheckup;

    @Before
    public void init() {
        dateCheckup = new DateCheckup();
    }

    @Test
    public void should_return_a_date_from_day_mont_and_year() {
        // GIVEN
        Instant expected = LocalDate.of(2007, 12, 27).atStartOfDay(ZoneId.systemDefault()).toInstant();
        // WHEN
        Instant date = dateCheckup.instance(27, 12, 2007).toInstant();
        // THEN
        assertEquals(expected, date);
    }

    @Test
    public void should_return_string_like_day_dd_mm_yyyy() {
        // GIVEN
        String expected = "jeudi 27 12 2007";
        // WHEN
        String result = dateCheckup.dateEnFrancaisLitteraire(dateCheckup.instance(27, 12, 2007));
        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void should_return_next_thursday() {
        // GIVEN
        Date expected = dateCheckup.instance(3, 1, 2008);
        // WHEN
        Date result = dateCheckup.jeudiProchain(dateCheckup.instance(27, 12, 2007));
        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void should_return_jour_en_7() {
        // GIVEN
        Date expected = dateCheckup.instance(3, 1, 2008);
        // WHEN
        Date result = dateCheckup.jourEn7(dateCheckup.instance(27, 12, 2007), DayOfWeek.THURSDAY);
        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void should_return_jour_en_15() {
        // GIVEN
        Date expected = dateCheckup.instance(9, 1, 2008);
        // WHEN
        Date result = dateCheckup.jourEn15(dateCheckup.instance(27, 12, 2007), DayOfWeek.WEDNESDAY);
        // THEN
        assertEquals(expected, result);
    }
}