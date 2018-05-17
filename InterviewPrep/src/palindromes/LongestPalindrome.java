package palindromes;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 * @author sunyuan
 *
 */
public class LongestPalindrome {
  public static String longestPalindrome(String s) {
    // get palindrome
    String palindrome = new StringBuilder(s).reverse().toString();
    
    // check substring in common
    int length = s.length();
    int max = 0;
    int index = 0;
    int[][] dp = new int[length][length];
    for (int i = 0; i < length; i++) {
      for(int j = 0; j < length; j++) {
        if(s.charAt(i) == palindrome.charAt(j)) {
          if(i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = dp[i-1][j-1] + 1;
          }
          
          if(max < dp[i][j]) {
            max = dp[i][j];
            index = j;
          }
        }
      }
    }
    
    return palindrome.substring(index - max + 1, index + 1);
  }
}
