package ru.mastiko.mconverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Mconverter {
    public static <T,P> List<P> function(List<T> list, Function<T, P> func)  {
        List<P> result = new ArrayList<>();
        for (T element : list) {
            result.add(func.apply(element));
        }
        return result;
    }
}
