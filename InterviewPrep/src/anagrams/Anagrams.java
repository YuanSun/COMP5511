package anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Anagrams {
  static boolean checkAnagrams (String str1, String str2) {
    return cleanupString(str1, true).equals(cleanupString(str2, true));
  }
  
  static String cleanupString (String str, Boolean needSort) {
    char[] arr = str.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
    if(needSort) {
      Arrays.sort(arr);
    }
    
    return new String(arr);
  }
  
  static boolean checkAnagrams2(String str1, String str2) {
    String cleanedStr1 = cleanupString(str1, false);
    String cleanedStr2 = cleanupString(str2, false);
    
    if(cleanedStr1.length() != cleanedStr2.length()) {
      return false;
    }
    
    Map<Character, Integer> strMap1 = new HashMap<>();
    Map<Character, Integer> strMap2 = new HashMap<>();
    
    // construct string map
    generateStringMap(strMap1, cleanedStr1);
    generateStringMap(strMap2, cleanedStr2);
    
    // use iterator to walk through map
    Iterator<Character> itr = strMap1.keySet().iterator();
    while(itr.hasNext()) {
      Character ch = (Character) itr.next();
      if (strMap1.get(ch) != strMap2.get(ch)) {
        return false;
      }
    }
    return true;
    
    // can also check equality of maps
   // return strMap1.equals(strMap2);
    
  }
  
  static void generateStringMap(Map<Character, Integer> strMap, String str) {
    for(Character ch: str.toCharArray()) {
      if(strMap.get(ch) == null) {
        strMap.put(ch, 1);
      } else {
        strMap.put(ch, strMap.get(ch) + 1);
      }
    }
  }
}
