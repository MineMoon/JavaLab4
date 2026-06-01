//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.mfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// FIXME: Отсутствует Javadoc для класса и методов,
// отступы составляют 4 пробела вместо 2,
// отсутствует проверка входных параметров на null,
// утилитарный класс должен иметь приватный конструктор и быть final,
// названия переменных pred и t не информативны (лучше использовать predicate и element).
// public class Mfilter {

//     public static <T> List<T> filter(List<T> list, Predicate<T> pred) {
//         List<T> result = new ArrayList<>();
//         for (T t : list) {
//             if (pred.test(t)) {
//                 result.add(t);
//             }
//         }
//         return result;
//     }
// }
//
// FIXTO:
/**
 * Utility class providing methods for filtering collections based on a predicate.
 */
public final class Mfilter {

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private Mfilter() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Filters the given list based on the provided predicate.
   *
   * @param <T>       the type of elements in the list.
   * @param list      the source list to filter.
   * @param predicate the condition to check for each element.
   * @return a new list containing elements that satisfy the predicate.
   * @throws IllegalArgumentException if the list or predicate is null.
   */
  public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
    if (list == null || predicate == null) {
      throw new IllegalArgumentException("List and predicate arguments cannot be null.");
    }

    List<T> result = new ArrayList<>();
    for (T element : list) {
      if (predicate.test(element)) {
        result.add(element);
      }
    }
    return result;
  }
}
