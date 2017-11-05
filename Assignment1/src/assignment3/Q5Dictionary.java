package assignment3;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    Collections.sort(data, new StrComparator());
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
    // Find indices for two corners
    long lo = 0, hi = (data.size() - 1);

    // Since array is sorted, an element present
    // in array must be in range defined by corner
    while (lo <= hi && minus(key, data.get((int) lo)) >= 0 && minus(key, data.get((int) hi)) <= 0) {
      // every loop, increment count
      ++count;

      // Probing the position with keeping
      // assume uniform distribution
      double distBetweenHiandLo = hi - lo;
      double distBetweenKeyHiandKeyLow = minus(data.get((int) hi), data.get((int) lo));
      double distBetweenKeyandLow = minus(key, data.get((int) lo));
      double sumU = distBetweenKeyandLow * distBetweenHiandLo / distBetweenKeyHiandKeyLow;
      long pos = (long) (lo + Math.ceil(sumU));

      // Condition of target found
      if (data.get((int) pos).equals(key)) {
        return (int) pos;
      }

      // If key is larger, key is in upper part
      if (minus(data.get((int) pos), key) < 0) {
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
  public double minus(String str1, String str2) {
    String str1Adj = str1.replaceAll(",", "");
    String str2Adj = str2.replaceAll(",", "");
    int maxlen = Math.max(str1Adj.length(), str2Adj.length());
    BigDecimal d = BigDecimal.ZERO;
    for (int i = 0; i < maxlen; i++) {
        int dist;
        if (i < str1Adj.length() && i < str2Adj.length()) {
            dist = str1Adj.charAt(i) - str2Adj.charAt(i);
        } else if (i < str1Adj.length()) {
            dist = str1Adj.charAt(i);
        } else {
            dist = -str2Adj.charAt(i);
        }
        d = d.add(BigDecimal.valueOf(dist * Math.pow(2, -i*8)));
    }
    return d.doubleValue();    
    
  }

  // customized comparator, to make sure sort and search using the same comparator
  private class StrComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      double result = minus (o1, o2); 
      //double compareFlag = 0.00000001;
      if (result > 0) {
        return 1;
      } 
      
      if (result < 0) {
        return -1;
      } 
      
      return 0;
    }
    
  }
}
