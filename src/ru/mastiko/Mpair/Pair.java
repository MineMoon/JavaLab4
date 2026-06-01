//FIXME:отсутствие авторских прав
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.Mpair;

// FIXME: Отсутствует Javadoc для класса и публичных методов,
// отступы составляют 4 пробела вместо 2,
// отсутствует конструктор по умолчанию и конструктор копирования,
// отсутствует проверка на null в методах,
// public class Pair {
//     private Object first;
//     private Object second;
//
//     public Object getFirst() {
//         return first;
//     }
//
//     public void setFirst(Object first) {
//         this.first = first;
//     }
//
//     public Object getSecond() {
//         return second;
//     }
//
//     public void setSecond(Object second) {
//         this.second = second;
//     }
//
//     public Pair(Object first, Object second) {
//         this.first = first;
//         this.second = second;
//     }
//
//     @Override
//     public String toString() {
//         return "(" + first + ";" + second + ")";
//     }
// }

// FIXTO:

/**
 * A utility class that holds a pair of two objects.
 */
public class Pair {

  private Object first;
  private Object second;

  /**
   * Default constructor initializing fields to null.
   */
  public Pair() {
    this.first = null;
    this.second = null;
  }

  /**
   * Constructs a pair with specified objects.
   *
   * @param first  the first object of the pair.
   * @param second the second object of the pair.
   */
  public Pair(Object first, Object second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Copy constructor.
   *
   * @param other the pair object to copy.
   */
  public Pair(Pair other) {
    if (other != null) {
      this.first = other.getFirst();
      this.second = other.getSecond();
    }
  }

  /**
   * Returns the first element of the pair.
   *
   * @return the first object.
   */
  public Object getFirst() {
    return first;
  }

  /**
   * Sets the first element of the pair.
   *
   * @param first the object to set.
   */
  public void setFirst(Object first) {
    this.first = first;
  }

  /**
   * Returns the second element of the pair.
   *
   * @return the second object.
   */
  public Object getSecond() {
    return second;
  }

  /**
   * Sets the second element of the pair.
   *
   * @param second the object to set.
   */
  public void setSecond(Object second) {
    this.second = second;
  }

  /**
   * Returns a string representation of the pair.
   *
   * @return formatted string as (first; second).
   */
  @Override
  public String toString() {
    return String.format("(%s; %s)", first, second);
  }
}