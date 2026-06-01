//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.datastructures;

import java.util.Arrays;

// FIXME: Нарушено именование класса (ListofValues -> ListOfValues), 
// отсутствует Javadoc для класса и методов,
// отступы составляют 4 пробела вместо 2,
// отсутствуют пробелы после ключевого слова if,
// используется общий RuntimeException вместо специфичного IndexOutOfBoundsException,
// в конструкторе массив присваивается напрямую без клонирования (риск изменения извне),
// отсутствуют проверки на null для входных данных.
// public class ImmutableListofValues<T> {
//     private final T[] array;

//     // properties
//     public T[] getArray() {
//         return array.clone();
//     }

//     // constructors
//     public ImmutableListofValues(T... numbers) {
//         this.array = numbers;
//     }

//     // copy constructor
//     public ImmutableListofValues(ImmutableListofValues<T> other) {
//         this.array = other.getArray();
//     }

//     // methods
//     public T get(int index) {
//         if (index < 0 || index >= this.array.length) {
//             throw new RuntimeException("Index out array's bounds");
//         }
//         return array[index];
//     }

//     public ImmutableListofValues<T> set(int index, T value) {
//         if (index < 0 || index >= array.length) {
//             throw new RuntimeException("Index out array's bounds");
//         }
//         T[] newArray = array.clone();
//         newArray[index] = value;
//         return new ImmutableListofValues<T>(newArray);
//     }

//     public boolean isEmpty() {
//         return array.length == 0;
//     }

//     public int size() {
//         return array.length;
//     }

//     @Override
//     public String toString() {
//         return Arrays.toString(array);
//     }
// }
//
// FIXTO:
/**
 * An immutable collection that wraps an array of values.
 *
 * @param <T> the type of elements in the list.
 */
public class ImmutableListOfValues<T> {

  private final T[] array;

  /**
   * Constructs an immutable list from the provided elements.
   *
   * @param values elements to store in the list.
   */
  @SafeVarargs
  public ImmutableListOfValues(T... values) {
    if (values == null) {
      this.array = (T[]) new Object[0];
    } else {
      // Cloning to ensure that the internal state cannot be modified from outside
      this.array = values.clone();
    }
  }

  /**
   * Copy constructor.
   *
   * @param other the list to copy.
   * @throws IllegalArgumentException if the provided list is null.
   */
  public ImmutableListOfValues(ImmutableListOfValues<T> other) {
    if (other == null) {
      throw new IllegalArgumentException("Source list cannot be null.");
    }
    this.array = other.getArray();
  }

  /**
   * Returns a copy of the underlying array.
   *
   * @return a clone of the internal array.
   */
  public T[] getArray() {
    return array.clone();
  }

  /**
   * Retrieves an element at the specified index.
   *
   * @param index index of the element to return.
   * @return the element at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public T get(int index) {
    if (index < 0 || index >= array.length) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
    }
    return array[index];
  }

  /**
   * Returns a new instance of ImmutableListOfValues with the updated value at the specified index.
   *
   * @param index index to modify.
   * @param value new value to set.
   * @return a new immutable list with the updated element.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public ImmutableListOfValues<T> set(int index, T value) {
    if (index < 0 || index >= array.length) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
    }
    T[] newArray = array.clone();
    newArray[index] = value;
    return new ImmutableListOfValues<>(newArray);
  }

  /**
   * Checks if the list is empty.
   *
   * @return true if the list contains no elements, false otherwise.
   */
  public boolean isEmpty() {
    return array.length == 0;
  }

  /**
   * Returns the number of elements in the list.
   *
   * @return the size of the list.
   */
  public int size() {
    return array.length;
  }

  @Override
  public String toString() {
    return Arrays.toString(array);
  }
}