//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.contraction;

import java.util.List;
import java.util.function.BinaryOperator;

// FIXME: Отсутствует Javadoc для класса и статического метода,
// отступы составляют 4 пробела вместо 2,
// используется неинформативное имя параметра "contrn",
// отсутствует проверка на null для оператора,
// лишний импорт java.util.ArrayList (не используется в коде).
// public class Contraction {
//
//     public static <T> T contraction(List<T> list, BinaryOperator<T> contrn) {
//         if (list == null || list.isEmpty()) {
//             throw new IllegalArgumentException("Cannot contraction empty list without elements");
//         }
//         T result = list.get(0);
//         for (int i = 1; i < list.size(); i++) {
//             result = contrn.apply(result, list.get(i));
//         }
//         return result;
//     }
// }

// FIXTO:

/**
 * Utility class providing methods to reduce or contract collections.
 */
public class Contraction {

  /**
   * Contracts a list into a single value using the provided binary operator.
   *
   * @param <T>      the type of elements in the list.
   * @param list     the list to be contracted.
   * @param operator the binary operator to apply (must not be null).
   * @return the result of the contraction.
   * @throws IllegalArgumentException if the list is null, empty, or operator is null.
   */
  public static <T> T contraction(List<T> list, BinaryOperator<T> operator) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException("Cannot contract an empty or null list.");
    }

    if (operator == null) {
      throw new IllegalArgumentException("Binary operator cannot be null.");
    }

    T result = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      result = operator.apply(result, list.get(i));
    }
    return result;
  }
}