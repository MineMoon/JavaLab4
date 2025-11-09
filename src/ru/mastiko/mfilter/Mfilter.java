package ru.mastiko.mfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Mfilter {

    public static <T> List<T> filter(List<T> list, Predicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (pred.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
