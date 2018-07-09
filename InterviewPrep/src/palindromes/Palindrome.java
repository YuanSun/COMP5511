package palindromes;

import java.util.ArrayList;
import java.util.List;

//--- Directions
//Given a string, return true if the string is a palindrome
//or false if it is not.  Palindromes are strings that
//form the same word if it is reversed. *Do* include spaces
//and punctuation in determining if the string is a palindrome.
//--- Examples:
//palindrome("abba") === true
//palindrome("abcdefg") === false
public class Palindrome {
  static boolean checkPalindrome(String str) {
    String reversed = new StringBuilder(str).reverse().toString();
    List<String> result = new ArrayList<>();
    
    
    int i = 0;
    result.add(String.valueOf(i));
    StringBuilder sb = new StringBuilder();
    sb.append(i);
    String temp = "4+2/4 ";
    System.out.println(temp.replaceAll(" ", ""));
    char[] arr = temp.toCharArray();
    
    for (char c : arr) {
      
    }
    
    return str.equals(reversed);
  }
}
