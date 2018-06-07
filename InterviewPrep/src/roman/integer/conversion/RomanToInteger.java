package roman.integer.conversion;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  private Map<Character, Integer> map = new HashMap<>();
  public RomanToInteger () {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }
  
  public int romanToInteger(String roman) {
    return romanToInt(roman).intValue();
  }
  
  private Integer romanToInt(String roman) {
    if(roman.length() == 1) {
      return map.get(roman.charAt(0));
    }
    
    if(map.get(roman.charAt(0)) >= map.get(roman.charAt(1))) {
      return map.get(roman.charAt(0)) + romanToInt(roman.substring(1));
    } else {
      return -1 * map.get(roman.charAt(0)) + romanToInt(roman.substring(1));
    }
  }
 }
