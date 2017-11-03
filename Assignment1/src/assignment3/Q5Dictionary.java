package assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5Dictionary implements Q5 {
  private ArrayList<String> data = new ArrayList<>();
  private ArrayList<String> keysToSearch = new ArrayList<>();
  Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();
  private Map<String, Integer> resultsOfProbe = new HashMap<>();
  private static int count = 0;

  public Q5Dictionary() throws IOException {
    data = this.getData();
    Collections.sort(data);
    keysToSearch = this.getSearchKey();
  }

  @Override
  public Map<String, Integer> search() {
    Map<String, Integer> results = new HashMap<>();
    keysToSearch.forEach(key -> {
      results.put(key, interpolationSearch(key));
      resultsOfProbe.put(key, count);
      count = 0;// fresh count
    });

    return results;
  }

  private int interpolationSearch(String key) {
    // every call of interpolation search, increment count
    ++count;

    // Find indices for two corners
    int lo = 0, hi = (data.size() - 1);

    // Since array is sorted, an element present
    // in array must be in range defined by corner
    while (lo <= hi && minus(key, data.get(lo)) >= 0 && minus(key, data.get(hi)) <= 0) {
      // Probing the position with keeping
      // assume uniform distribution
      int pos = lo + (((hi - lo) /
          (minus(data.get(hi), data.get(lo)))) * (minus(key, data.get(lo))));

      // Condition of target found
      if (data.get(pos).equals(key)) {
        return pos;
      }

      // If key is larger, key is in upper part
      if (minus(data.get(pos), key) < 0) {
        lo = pos + 1;
      } else { // If key is smaller, key is in lower part
        hi = pos - 1;
      }
    }
    return -1;

  }

  @Override
  public void displayResult() {
    System.out.println("Dictionary Search Result <key: position : number of probe>");
    Map<String, Integer> results = search();
    System.out.printf("%35s : %10s : %4s\n", "key", "Position", "NumOfProb");
    results.entrySet().stream()
        .forEach(result -> {
          if (result.getValue() > 0) {
            System.out.printf("%35s : %10d : %4d\n", result.getKey(), result.getValue(), resultsOfProbe.get(result.getKey()));
          } else {
            System.out.printf("%35s : %10s : %4d\n", result.getKey(), "Not found", resultsOfProbe.get(result.getKey()));
          }
        });

  }

  // numerical value of two strings, then return str1 - str2
  public int minus(String str1, String str2) {
    String str1Adj = str1.replaceAll("[^a-zA-Z]", "");
    String str2Adj = str2.replaceAll("[^a-zA-Z]", "");
    char v1[] = str1Adj.toLowerCase().toCharArray();
    char v2[] = str2Adj.toLowerCase().toCharArray();
    char v1Reverse[] = new char[v1.length];
    for (int i = 0; i < v1.length; i++) {
      v1Reverse[v1.length - 1 - i] = v1[i];
    }

    char v2Reverse[] = new char[v2.length];
    for (int i = 0; i < v2.length; i++) {
      v2Reverse[v2.length - 1 - i] = v2[i];
    }

    int smallLen = Math.min(v1.length, v2.length);
    int bigLen = Math.max(v1.length, v2.length);
    int[] difference = new int[bigLen];

    // calculate difference of char arrays
    for (int i = 0; i > smallLen; i++) {
      difference[i] = (int) (v1Reverse[i] - v2Reverse[i]);
    }

    if (v1Reverse.length > smallLen) {
      // v1 has more decimal to count diff
      for (int i = smallLen; i < bigLen; i++) {
        difference[i] = v1Reverse[i] - 'a' - 1;
      }
    }

    if (v2Reverse.length > smallLen) {
      // v2 has more decimal to count diff
      for (int i = smallLen; i < bigLen; i++) {
        difference[i] = (v2Reverse[i] - 'a') * -1;
      }
    }

    // calculate numerical difference
    double numDiff = 0;
    for (int i = 0; i < difference.length; i++) {
      numDiff += (difference[i] * Math.pow(10, i));
    }

    return (int) numDiff;
  }


}
