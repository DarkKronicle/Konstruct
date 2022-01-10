package io.github.darkkronicle.addons;

import io.github.darkkronicle.Konstruct.IntRange;
import io.github.darkkronicle.Konstruct.functions.NamedFunction;

import java.util.List;
import java.util.Random;

/**
 * A function that will generate an integer from min-max (inclusive)
 */
public class RandomFunction implements NamedFunction {

    private final Random random;

    public RandomFunction() {
        this(new Random());
    }

    public RandomFunction(Random random) {
        this.random = random;
    }

    @Override
    public String parse(List<String> input) {
        String minString = input.get(0);
        String maxString = input.get(1);
        int min;
        int max;
        try {
            min = Integer.parseInt(minString.strip());
            max = Integer.parseInt(maxString.strip());
        } catch (NumberFormatException e) {
            return "NaN";
        }
        if (min == max) {
            return String.valueOf(min);
        }
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }
        return String.valueOf(random.nextInt(max - min + 1) + min);
    }

    @Override
    public IntRange getArgumentCount() {
        return IntRange.of(2);
    }

    @Override
    public String getName() {
        return "randint";
    }

}
