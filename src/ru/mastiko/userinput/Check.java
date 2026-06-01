//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

//FIXME: camelCase, Отсутствие Javadoc, форматирование отступов 
// public class Check {

// 	public boolean isInteger(String str) {
// 		try {
// 			Integer.parseInt(str);
// 			return true;
// 		} catch (NumberFormatException e) {
// 			return false;
// 		}
// 	}

// 	public boolean Positive (int num) {
// 		return num >= 0;
// 	}

// }
//
//FIXTO:
/**
 * Utility class for numerical checks and calculations.
 */
public class Check {

  /**
   * Checks if a string can be parsed as an integer.
   *
   * @param input the string to check.
   * @return true if the string is a valid integer, false otherwise.
   */
  public boolean isInteger(String input) {
    if (input == null || input.isEmpty()) {
      return false;
    }
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Checks if a number is positive.
   *
   * @param number the integer to check.
   */
  public boolean isPositive (int num) {
    return num >= 0;
  }
   
   
}