package ru.mastiko.mcollect;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class MCollector {

    public static <T, P> P collect(List<T> list,
            Supplier<P> collectionFactory,
            BiConsumer<P, T> accumulator) {

        P result = collectionFactory.get();
        for (T element : list) {
            accumulator.accept(result, element);
        }
        return result;
    }
}