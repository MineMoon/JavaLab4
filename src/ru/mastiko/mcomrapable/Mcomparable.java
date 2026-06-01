//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.p

package ru.mastiko.mcomrapable;

// FIXME: Отсутствует Javadoc для интерфейса и метода,
// отступы составляют 4 пробела вместо 2,
// public interface Mcomparable<T> {
//     int compareTo(T obj);
// }
//
// FIXTO:
/**
 * A custom interface for comparing objects of the same type.
 *
 * @param <T> the type of objects that this object may be compared to.
 */
public interface Mcomparable<T> {

  /**
   * Compares this object with the specified object for order.
   *
   * @param obj the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object
   *         is less than, equal to, or greater than the specified object.
   */
  int compareTo(T obj);
}
