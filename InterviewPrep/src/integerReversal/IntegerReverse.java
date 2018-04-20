package integerReversal;
//--- Directions
//Given an integer, return an integer that is the reverse
//ordering of numbers.
//--- Examples
//reverseInt(15) === 51
//reverseInt(981) === 189
//reverseInt(500) === 5
//reverseInt(-15) === -51
//reverseInt(-90) === -9
public class IntegerReverse {
  static int reverse(int num) {
    String numStr = new String(String.valueOf(Math.abs(num)));
    
    String reversedStr = new StringBuilder(numStr).reverse().toString();
    
    int reversedNum = new Integer(reversedStr);
    if (num < 0) {
      reversedNum *= -1;
    }
    
    return reversedNum;
  }
}
