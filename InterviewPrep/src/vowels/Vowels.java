package vowels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Vowels {
  static int countVowels(String str) {
    int count = 0;
    for (Character ch: str.toLowerCase().toCharArray()) {
      if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        count ++;
      }
    }
    
    return count;
  }
  
  static int countVowelsReg(String str) {
    int count = 0;
    Pattern pattern = Pattern.compile("[aeiouâãäåæçèéêëìíîïðñòóôõøùúûü]", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
      count++;
    }
    
    return count;
  }
}