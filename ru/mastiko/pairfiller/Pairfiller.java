package ru.mastiko.pairfiller;

import java.util.List;
import java.util.function.IntFunction;
import ru.mastiko.Mpair.Pair;

public class Pairfiller {

    public static <T extends Number, U extends Number> void oneHungredFiller(
            List<Pair<T, U>> list,
            IntFunction<T> firstConverter,
            IntFunction<U> secondConverter) {

        if (firstConverter == null || secondConverter == null) {
            throw new NullPointerException("Converters cannot be null");
        }

        for (int i = 1; i <= 100; i++) {
            list.add(new Pair<>(firstConverter.apply(i), secondConverter.apply(i)));
        }
    }
}
