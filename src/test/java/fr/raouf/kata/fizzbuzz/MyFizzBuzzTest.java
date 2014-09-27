package fr.raouf.kata.fizzbuzz;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MyFizzBuzzTest {
    private static final int MAX = 9999;
    public static final Integer[] INTEGER_ARRAY = IntStream.range(0, MAX).boxed().toArray(Integer[]::new);

    private MyFizzBuzz fizzBuzz = new MyFizzBuzz();

    @Test
    public void should_return_input_when_input_not_divisable_by_3_or_by_5() {
        int[] input = {0, 1, 2, 4, 7, 8, 11, 13, 14};

        // WHEN
        // THEN
        for (int i : input) {
            String result = fizzBuzz.stringValue(i);
            assertEquals(String.valueOf(i), result);
        }
    }

    @Test
    public void should_return_fizz_when_input_divisable_by_3() {
        // GIVEN
        String expected = "FIZZ";
        // WHEN
        String result = fizzBuzz.stringValue(3 * 7);
        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void should_return_fizz_when_input_divisable_by_5() {
        // GIVEN
        String expected = "BUZZ";
        // WHEN
        String result = fizzBuzz.stringValue(5 * 4);
        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void should_return_fizz_when_input_divisable_by_15() {
        // GIVEN
        String expected = "FIZZBUZZ";
        // WHEN
        String result = fizzBuzz.stringValue(15 * 3);
        // THEN
        assertEquals(expected, result);
    }
}