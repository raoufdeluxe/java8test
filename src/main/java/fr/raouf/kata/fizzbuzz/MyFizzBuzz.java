package fr.raouf.kata.fizzbuzz;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by raphael on 21/09/14.
 */
public class MyFizzBuzz {
    private static final Function<Integer, String> INTEGER_PRINTER = (i) -> {
        String r = "";
        if (i > 0) {
            for (Enum current : Enum.values()) {
                if (i % current.divisor() == 0) r += current;
            }
        }
        return r.length() > 0 ? r : String.valueOf(i);
    };

    public String stringValue(Integer... input) {
        return Arrays.asList(input).stream().map(INTEGER_PRINTER).collect(Collectors.joining(" "));
    }

    private enum Enum {
        FIZZ(3), BUZZ(5);
        int div;

        Enum(int i) {
            div = i;
        }

        public int divisor() {
            return div;
        }
    }
}
