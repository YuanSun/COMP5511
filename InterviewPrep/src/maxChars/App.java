package maxChars;

import java.util.Map;
import java.util.TreeMap;

public class App {

  public static void main(String[] args) {
    String str = "abcccccccd";
    
    Map<Character, Integer> maxChar = MaxChar.findMaxCharAlternative(str);
    
    System.out.println("Max char is :");
 
    maxChar.entrySet().stream().forEach((e) -> {
      System.out.println(e.getKey() + " -- " + e.getValue());
    });
    
    Map table = new TreeMap();

  }

}
