package assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Q5BinarySearch implements Q5{
  private ArrayList<String> data = new ArrayList<>();
  private ArrayList<String> keysToSearch = new ArrayList<>();
  
  public Q5BinarySearch() throws IOException {
    data = this.getData();
    Collections.sort(data);
    keysToSearch = this.getSearchKey();
  }

  @Override
  public Map<String, Integer> search() {
    Map<String, Integer> results = new HashMap<>();
    keysToSearch.forEach(key -> {
      results.put(key, binarySearch(data, 0, data.size() - 1, key));
    });
    
    return results;
  }
  
  private int binarySearch(ArrayList<String> arr, int l, int r, String key) {
    if (r >= l) {
      int mid = l + (r - l) / 2;
      
      if (arr.get(mid).equals(key)) {
        return mid;
      }
      
      if (arr.get(mid).compareTo(key) > 0) {
        return binarySearch(arr, l, mid - 1, key);
      } 
      
      return binarySearch(arr, mid + 1, r, key);
    }
    
    // if nothing found, return -1
    return -1;
  }
  
  @Override
  public void displayResult() {
    System.out.println("Binary Search Result <key: position>");
    Map<String, Integer> results = search();
    results.entrySet().stream()
    .forEach(result -> {
      if(result.getValue() > 0) {
        System.out.println(result.getKey() + ": " + result.getValue());
      } else {
        System.out.println(result.getKey() + ": Not found");
      }
    });
  }
}
