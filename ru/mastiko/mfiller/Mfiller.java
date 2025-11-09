package ru.mastiko.mfiller;

import java.util.List;
import java.util.function.IntFunction;

public class Mfiller {
    public static <T extends Number> void oneHungredFiller(
            List<T> list,
            IntFunction<T> Converter ) {

        if (Converter == null ) {
            throw new NullPointerException("Converters cannot be null");
        }

        for (int i = 1; i <= 100; i++) {
            list.add(Converter.apply(i));
        }
    }
}
