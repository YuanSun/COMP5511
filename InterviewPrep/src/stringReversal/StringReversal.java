package stringReversal;

//--- Directions
//Given a string, return a new string with the reversed
//order of characters
//--- Examples
//reverse('apple') === 'leppa'
//reverse('hello') === 'olleh'
//reverse('Greetings!') === '!sgniteerG'

public class StringReversal {
  static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
  
  static String reverseRecur(String str) {
    if (str == null || str.length() <= 1) {
      return str;
    }
    
    return reverseRecur(str.substring(1)) + str.charAt(0);
  }
}
