//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.mcollect;
// FIXME: импорты содержат "звездочку" (wildcards),
// import java.util.*;
// import java.util.function.BiConsumer;
// import java.util.function.Supplier;
//
//FIXTO:
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


// FIXME: Отсутствует Javadoc для класса и методов,
// отступы составляют 4 пробела вместо 2,
// отсутствует проверка входных параметров на null,
// утилитарный класс должен иметь приватный конструктор.
// public class MCollector {

//     public static <T, P> P collect(List<T> list,
//             Supplier<P> collectionFactory,
//             BiConsumer<P, T> accumulator) {

//         P result = collectionFactory.get();
//         for (T element : list) {
//             accumulator.accept(result, element);
//         }
//         return result;
//     }
// }
//
// FIXTO:
/**
 * Utility class for collecting elements from a list into a custom container.
 */
public final class MCollector {

  /**
   * Private constructor to prevent instantiation of utility class.
   */
  private MCollector() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Processes a list and collects its elements into a container provided by the factory.
   *
   * @param <T>               the type of elements in the source list.
   * @param <P>               the type of the result container.
   * @param list              the source list of elements.
   * @param collectionFactory a supplier providing a new result container.
   * @param accumulator       a consumer that folds an element into the result container.
   * @return the result container filled with processed elements.
   * @throws IllegalArgumentException if any of the arguments are null.
   */
  public static <T, P> P collect(List<T> list,
                                 Supplier<P> collectionFactory,
                                 BiConsumer<P, T> accumulator) {

    if (list == null || collectionFactory == null || accumulator == null) {
      throw new IllegalArgumentException("Arguments for collect method cannot be null.");
    }

    P result = collectionFactory.get();
    for (T element : list) {
      accumulator.accept(result, element);
    }
    return result;
  }
}