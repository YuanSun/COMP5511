package wordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] arr = str.split(" "); 
    String[] patternArr = pattern.split("");
    // edge case
    if (arr.length != patternArr.length || pattern.equals("")) {
        return false;
    }
    
    Map<String, String> map = new HashMap<>();
    
    int l = pattern.length();
    for (int i = 0; i < l; i++) {
        if(!map.containsValue(arr[i]) && !map.containsKey(patternArr[i])) {
            map.put(patternArr[i], arr[i]);
        } else {
            if( !map.get(patternArr[i]).equals(arr[i])) {
                return false;
            }
        }
    }
    
    return true;
    

  }
}
