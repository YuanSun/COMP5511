package assignment3;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q4SortedList implements Q4 {
  public Map<String, Double> studentGAP = new HashMap<>();

  public Q4SortedList() throws FileNotFoundException {
    studentGAP = this.getGPAData();
  }

  // * Use insertion algorithm to sort the map by value.
  // * Insertion algorithm is implemented on two steps: step 2 and step 3
  // * step 2: compare the entry
  // * step 3: insert the entry to a new map based on the comparison
  private static Map<String, Double> sortByValue(Map<String, Double> unsortMap) {

    // 1. Convert Map to List of Map
    List<Map.Entry<String, Double>> list =
        new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

    // 2. Sort list with Collections.sort(), provide a custom Comparator
    // Try switch the o1 o2 position for a different order
    Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
      public int compare(Map.Entry<String, Double> o1,
          Map.Entry<String, Double> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
    Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
    for (Map.Entry<String, Double> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }

  @Override
  public Map<String, Double> findLowestGPAs(int k) {
    // TODO Auto-generated method stub
    return null;
  }

}
