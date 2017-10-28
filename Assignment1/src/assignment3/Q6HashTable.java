package assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Q6HashTable implements Q6{
  final int SIZE = 2657; // requirement of Question 6
  private ArrayList<String> data = new ArrayList<>();
  private ArrayList<String> keysToSearch = new ArrayList<>();
  public Hashtable<Integer, String> hashTable = new Hashtable<>(SIZE);
  
  public Q6HashTable() throws IOException {

    data = this.getData();
    keysToSearch = this.getSearchKey();
  }
  
  // construct hash table using folding method
  private void generateHashTable() {
    // folding method
    data.forEach(name -> {
      Integer key = hash(name);
      Integer stepSize = doubleHash(key);
      while(hashTable.get(key) != null) {
        // double hashing
        key += stepSize;
        key %= SIZE;
      }
      hashTable.put(key, name);
      
    });
  }
  
  private Integer hash(String str) {
    int sum = str.chars().map(Integer::new)
        .sum();
    return sum % SIZE;
  }
  
  private Integer doubleHash(Integer key ) {
    return 5 - key % 5;
  }
  
  @Override
  public Map<String, Integer> search() {
    // key , number of probe
    // number of probe = -1 means not found
    Map<String, Integer> results = new HashMap<>();
    
    // 1. construct hash Table, assume table is not empty
    generateHashTable();
    if(hashTable.isEmpty())
      return null;
    
    // 2. search key in the hashTable, 
    // and count probes
    
    keysToSearch.forEach(key -> {
      results.put(key, find(key));
    });
    
    return results;
  }
  
  private Integer find(String key) {
    int count = 0;
    // 2.1 hash key
    Integer hashVal = hash(key);
    Integer stepSize = doubleHash(hashVal);
    while(hashTable.get(hashVal) != null) {
      if(hashTable.get(hashVal).equals(key)) {
        return ++count;
      } else {
        // go to next cell
        hashVal += stepSize;
        hashVal %= SIZE; // wrap around if necessary
        ++count; //
      }
    }
   return count * -1; 
  }


  @Override
  public void displayResult() {
    Map<String, Integer> results = search();
    
    System.out.println("Search with hash table <key: numOfProbe>");
    results.entrySet().forEach(result -> {
      if (result.getValue() > 0) {
        System.out.println(result.getKey() + ": " + result.getValue());
      } else {
        System.out.println(result.getKey() + " not found" + " : " + result.getValue() * -1);
      }
    });
    
  }

}
