package maxChars;

import java.util.HashMap;
import java.util.Map;

// --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"
public class MaxChar {
  static Map<Character, Integer> findMaxChar(String str) {
    Map<Character, Integer> charMap = new HashMap<>();

    // construct char map
    for (Character ch : str.toCharArray()) {
      if (charMap.get(ch) == null) {
        charMap.put(ch, 1);
      } else {
        charMap.put(ch, charMap.get(ch) + 1);
      }
    }

    // find max char entry
    Map.Entry<Character, Integer> maxEntry = null;
    for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }

    Map<Character, Integer> result = new HashMap<Character, Integer>();
    result.put(maxEntry.getKey(), maxEntry.getValue());
    return result;
  }

  static Map<Character, Integer> findMaxCharAlternative(String str) {
    Map<Character, Integer> charMap = new HashMap<>();

    // construct char map
    for (Character ch : str.toCharArray()) {
      if (charMap.get(ch) == null) {
        charMap.put(ch, 1);
      } else {
        charMap.put(ch, charMap.get(ch) + 1);
      }
    }

    // use stream to find max entry
    Map.Entry<Character, Integer> maxEntry = charMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();

    Map<Character, Integer> result = new HashMap<Character, Integer>();
    result.put(maxEntry.getKey(), maxEntry.getValue());
    return result;
  }
}
