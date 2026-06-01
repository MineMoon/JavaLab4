//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package ru.mastiko.house;

import ru.mastiko.mcomrapable.Mcomparable;

// FIXME: Отсутствует Javadoc для класса и методов,
// отступы составляют 4 пробела вместо 2,
// отсутствуют пробелы после ключевых слов if и else,
// используются магические числа (164) вместо констант,
// интерфейс toString реализован на русском языке, и вообще есть вывод на русском
// используется слишком общий RuntimeException вместо IllegalArgumentException,
// отсутствует проверка на null в конструкторе копирования.
// public class House implements Mcomparable<House> {
//     private final int floor;

//     // properties
//     public int getFloor() {
//         return floor;
//     }

//     // constructor
//     public House(int floor) {
//         if(floor < 0){
//             throw new RuntimeException("Floor cannot be negative");
//         } else if(floor > 164) {
//             this.floor = 1;
//         } else {
//             this.floor = floor;
//         }
//     }

//     // copy
//     public House(House house) {
//         this.floor = house.getFloor();
//     }

//     //methods
//     @Override
//     public int compareTo(House other) {
//         return Integer.compare(this.floor, other.floor);
//     }

//     @Override
//     public String toString() {

//         if (floor % 100 >= 11 && floor % 100 <= 14) {
//             return String.format("Дом с %d %s", floor, "этажами");
//         }
//         if(floor % 10 == 1){
//             return String.format("Дом с %d %s", floor, "этажом");
//         }

//         return String.format("Дом с %d %s", floor, "этажами");
//     }

// }
//
// FIXTO:
/**
 * Represents a house with a specific number of floors.
 * Implements Mcomparable for comparing houses by floor count.
 */
public class House implements Mcomparable<House> {

  private static final int MIN_FLOORS = 1;
  private static final int MAX_FLOORS = 164;
  private static final int DEFAULT_FLOORS = 1;

  private final int floor;

  /**
   * Constructs a house with a validated number of floors.
   *
   * @param floor the number of floors.
   * @throws IllegalArgumentException if the floor number is negative.
   */
  public House(int floor) {
    if (floor < 0) {
      throw new IllegalArgumentException("Floor count cannot be negative.");
    }

    if (floor > MAX_FLOORS) {
      this.floor = DEFAULT_FLOORS;
    } else {
      this.floor = floor;
    }
  }

  /**
   * Copy constructor.
   *
   * @param house the house object to copy.
   * @throws IllegalArgumentException if the provided house is null.
   */
  public House(House house) {
    if (house == null) {
      throw new IllegalArgumentException("Source house cannot be null.");
    }
    this.floor = house.getFloor();
  }

  /**
   * Returns the number of floors in the house.
   *
   * @return the floor count.
   */
  public int getFloor() {
    return floor;
  }

  /**
   * Compares this house with another house by floor count.
   *
   * @param other the other house to compare to.
   * @return a negative integer, zero, or a positive integer as this house
   *         has fewer, equal, or more floors than the specified house.
   */
  @Override
  public int compareTo(House other) {
    if (other == null) {
      return 1;
    }
    return Integer.compare(this.floor, other.floor);
  }

  /**
   * Returns a string representation of the house in English.
   *
   * @return formatted string with floor count.
   */
  @Override
  public String toString() {
    String suffix = (floor == 1) ? "floor" : "floors";
    return String.format("House with %d %s", floor, suffix);
  }
}