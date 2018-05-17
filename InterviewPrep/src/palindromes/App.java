package palindromes;

public class App {
  public static void main(String[] args) {
    String str = "abcdasdfghjkldcba";

    System.out.println(Palindrome.checkPalindrome(str));
    
    System.out.println(LongestPalindrome.longestPalindrome(str));
  }
}
