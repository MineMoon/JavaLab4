package ru.mastiko.contraction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Contraction {

    public static <T> T contraction(List<T> list, BinaryOperator<T> contrn) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Cannot contraction empty list without elements");
        }
        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = contrn.apply(result, list.get(i));
        }
        return result;

    }

}
