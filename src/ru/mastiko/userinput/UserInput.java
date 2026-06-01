//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

import java.util.Scanner;


// FIXME: Отсутствует Javadoc для публичных методов, 
// отступы составляют 4 пробела вместо 2,
// отсутствуют пробелы после ключевых слов if,
// while и catch, интерфейс взаимодействия с пользователем реализован на русском языке,
// используется неверный термин Diaposon вместо Range, 
// отсутствуют обязательные фигурные скобки в некоторых блоках if.
// public class UserInput {
// 	private final Scanner scanner = new Scanner(System.in);
// 	private final Check check = new Check();
// 	private String input;

// 	public int inputInt(int number){
// 		if(number == 0){
// 			System.out.println("Введите число: ");
// 		}
// 		else if(number>0){
// 			System.out.println("Введите " + number + "-ое число: ");
// 		}

// 		input = scanner.nextLine();
// 		while (!check.isInteger(input)){
// 			System.out.println("Некорректный ввод!");
// 			if(number == 0){
// 				System.out.println("Введите число: ");
// 			}
// 			else if(number>0){
// 				System.out.println("Введите " + number + "-ое число: ");
// 			}
// 			input = scanner.nextLine();
// 		}
// 		return Integer.parseInt(input);
// 	}

// 	public int inputPositiveInt(int number){
// 		if(number == 0){
// 			System.out.println("Введите целое число: ");
// 		}
// 		else if(number>0){
// 			System.out.println("Введите " + number + "-ое целое число: ");
// 		}

// 		input = scanner.nextLine();

// 		while (true) {
// 			try {
// 				int value = Integer.parseInt(input);
// 				if (value < 0) {
// 					System.out.println("Число должно быть положительным!");
// 					if(number == 0){
// 						System.out.println("Введите целое число: ");
// 					}
// 					else if(number>0){
// 						System.out.println("Введите " + number + "-ое целое число: ");
// 					}
// 				} else {
// 					return value;
// 				}
// 			} catch (NumberFormatException e) {
// 				System.out.println("Некорректный ввод!");
// 				if(number == 0){
// 					System.out.println("Введите целое число: ");
// 				}
// 				else if(number>0){
// 					System.out.println("Введите " + number + "-ое целое число: ");
// 				}
// 			}
// 			input = scanner.nextLine();
// 		}
// 	}

// 	public String inputString(String what){
// 		System.out.println("Введите "+ what + ": ");
// 		input = scanner.nextLine();
// 		return input;
// 	}

// 	public int inputDiaposonInt(int start, int end, String what){
// 		System.out.println("Введите "+ what+ " от " + start + " до " + end + ": ");

// 		input = scanner.nextLine();
// 		while (!check.isInteger(input)) {
// 			System.out.println("Некорректный ввод!");
// 				System.out.println("Введите число от" + start + " до " + end + ": ");
// 			input = scanner.nextLine();
// 		}
// 		while (!(start<=Integer.parseInt(input)&&(end>=Integer.parseInt(input)))) {
// 			System.out.println("Диапозон от " + start + " до " + end + "!");

// 			System.out.println("Введите "+ what+ " от " + start + " до " + end + ": ");
// 			input = scanner.nextLine();
// 			while (!check.isInteger(input)) {
// 				System.out.println("Некорректный ввод!");
// 				System.out.println("Введите число от" + start + " до " + end + ": ");
// 				input = scanner.nextLine();
// 			}
// 		}
// 		return Integer.parseInt(input);
// 	}

// 	public int inputChoiceInt(int start, int end, String what){
// 		System.out.println("Выберете "+ what);

// 		input = scanner.nextLine();
// 		while (!check.isInteger(input)) {
// 			System.out.println("Некорректный ввод!");
// 			System.out.println("Введите число от " + start + " до " + end + "!");
// 			System.out.println("Выберете "+ what);
// 			input = scanner.nextLine();
// 		}
// 		while (!(start <= Integer.parseInt(input) && (end >= Integer.parseInt(input)))) {
// 			System.out.println("Диапозон от " + start + " до " + end + "!");
// 			System.out.println("Выберете "+ what);
// 			input = scanner.nextLine();
// 			while (!check.isInteger(input)) {
// 				System.out.println("Введите число от " + start + " до " + end + "!");
// 				System.out.println("Выберете "+ what);
// 				input = scanner.nextLine();
// 			}
// 		}
// 		return Integer.parseInt(input);
// 	}

// 	public int[] inputIntArray(int size){
// 		int[] array = new int[size];
// 		for(int i = 1; i <= size; i++){
// 			array[i-1] = inputInt(i);
// 		}
// 		return array;
// 	}
// }
//
//FIXTO:
/**
 * Provides methods for validated user input from the console.
 */
public class UserInput {

  private final Scanner scanner = new Scanner(System.in);
  private final Check check = new Check();

  /**
   * Reads an integer with an optional ordinal number prompt.
   *
   * @param ordinal the position of the number in a sequence (0 to skip).
   * @return the entered integer.
   */
  public int inputInt(int ordinal) {
    if (ordinal == 0) {
      System.out.println("Enter a number: ");
    } else if (ordinal > 0) {
      System.out.println("Enter number #" + ordinal + ": ");
    }

    String input = scanner.nextLine();
    while (!check.isInteger(input)) {
      System.out.println("Invalid input! Please enter an integer.");
      input = scanner.nextLine();
    }
    return Integer.parseInt(input);
  }

  /**
   * Reads a positive integer (>= 0).
   *
   * @param ordinal the position of the number in a sequence.
   * @return a positive integer.
   */
  public int inputPositiveInt(int ordinal) {
    while (true) {
      if (ordinal == 0) {
        System.out.println("Enter a positive integer: ");
      } else {
        System.out.println("Enter positive integer #" + ordinal + ": ");
      }

      String input = scanner.nextLine();
      try {
        int value = Integer.parseInt(input);
        if (value < 0) {
          System.out.println("The number must be positive!");
        } else {
          return value;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a valid integer.");
      }
    }
  }

  /**
   * Reads a string from the console.
   *
   * @param context description of what to enter.
   * @return the entered string.
   */
  public String inputString(String context) {
    System.out.println("Enter " + context + ": ");
    return scanner.nextLine();
  }

  /**
   * Reads an integer within a specific range.
   *
   * @param start start of the range (inclusive).
   * @param end end of the range (inclusive).
   * @param context description of the value.
   * @return an integer within the specified range.
   */
  public int inputRangeInt(int start, int end, String context) {
    while (true) {
      System.out.println("Enter " + context + " (from " + start + " to " + end + "): ");
      String input = scanner.nextLine();

      if (check.isInteger(input)) {
        int value = Integer.parseInt(input);
        if (value >= start && value <= end) {
          return value;
        }
        System.out.println("Value must be between " + start + " and " + end + "!");
      } else {
        System.out.println("Invalid input! Please enter a valid number.");
      }
    }
  }

  /**
   * Reads an integer choice within a range.
   *
   * @param start start of choices.
   * @param end end of choices.
   * @param context description of the choice.
   * @return the selected option.
   */
  public int inputChoiceInt(int start, int end, String context) {
    System.out.println("Select " + context + ":");
    return inputRangeInt(start, end, "choice");
  }

  /**
   * Reads an array of integers.
   *
   * @param size size of the array.
   * @return the filled array.
   */
  public int[] inputIntArray(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = inputInt(i + 1);
    }
    return array;
  }
}