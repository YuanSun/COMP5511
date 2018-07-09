package valid.palindrome;

public class ValidPalindrome {
  public static boolean isPalindrome(String s) {
    if (s == null || s.equals("")) {
        return true;
    }
    
    // clean the string
    String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    String reversed = new StringBuilder(clean).reverse().toString();
    
    return clean.equals(reversed);
  }
  
  public static boolean isPalin(String s) {
      if (s == null || s.equals("")) {
        return true;
      }
      
      // clean the string
      String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
      
      char[] arr = clean.toCharArray();
      int i = 0, j = arr.length - 1;
      while(i < j) {
          if(arr[i] != arr[j]) {
              return false;
          }
          i++;
          j--;
      }
      return true;
    }
}
