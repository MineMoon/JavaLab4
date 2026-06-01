//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.mconverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// FIXME: Отсутствует Javadoc для класса и методов,
// отступы составляют 4 пробела вместо 2,
// отсутствует пробел между типами в дженерике <T,P>,
// отсутствует проверка входных параметров на null,
// утилитарный класс должен иметь приватный конструктор и быть final.
// public class Mconverter {
//     public static <T,P> List<P> function(List<T> list, Function<T, P> func)  {
//         List<P> result = new ArrayList<>();
//         for (T element : list) {
//             result.add(func.apply(element));
//         }
//         return result;
//     }
// }
//
// FIXTO:
/**
 * Utility class for converting lists using a transformation function.
 */
public final class Mconverter {

  /**
   * Private constructor to prevent instantiation.
   */
  private Mconverter() {
    throw new UnsupportedOperationException("Utility class");
  }

  /**
   * Transforms each element of the list using the provided function.
   *
   * @param <T>      the type of elements in the source list.
   * @param <P>      the type of elements in the resulting list.
   * @param list     the source list to convert.
   * @param function the function to apply to each element.
   * @return a new list containing the transformed elements.
   * @throws IllegalArgumentException if list or function is null.
   */
  public static <T, P> List<P> function(List<T> list, Function<T, P> function) {
    if (list == null || function == null) {
      throw new IllegalArgumentException("List and function arguments cannot be null.");
    }

    List<P> result = new ArrayList<>();
    for (T element : list) {
      result.add(function.apply(element));
    }
    return result;
  }
}
