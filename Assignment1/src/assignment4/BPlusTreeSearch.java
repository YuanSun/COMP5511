package assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BPlusTreeSearch implements Ass3Q7 {
  private ArrayList<String> data = new ArrayList<>();
  private ArrayList<String> keysToSearch = new ArrayList<>();
  private BPlusTree<String, String> tree = new BPlusTree(5);
  private Map<String, Map<String, Integer>> searchResult = new HashMap<>();

  public BPlusTreeSearch() throws IOException {
    data = this.getData();
    keysToSearch = this.getSearchKey();

    // fill data into tree
    data.forEach(name -> {
      tree.insert(name, name);
    });
  }

  public Map<String, Map<String, Integer>> search() {
    keysToSearch.forEach(key -> {
      Map<String, Integer> result = new HashMap<>();
      result = tree.find(key);
      if (result.containsValue(-1)) {
        searchResult.put(key, null); // not found
      } else {
        searchResult.put(key, result);
      }
    });

    return this.searchResult;
  }

  public void displayResult() {
    Map<String, Map<String, Integer>> results = search();

    System.out.println("Search with B plus tree <key: numOfNodeAccessed>");
    System.out.printf("%35s : %10s\n", "key", "numOfNodeAccessed");
    results.entrySet().forEach(result -> {
      if (!(result.getValue() == null)) {
        System.out.printf("%35s : %4d \n", result.getKey(), result.getValue().values().toArray()[0]);
      } else {
        System.out.printf("%35s : %10s\n", result.getKey(), "not found");
      }
    });

  }

}
