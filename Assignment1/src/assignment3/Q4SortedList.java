package assignment3;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q4SortedList implements Q4 {
  private Map<String, Double> studentGPA = new HashMap<>();
  private Map<String, Double> lowestKGPA = new HashMap<>();

  public Q4SortedList() throws FileNotFoundException {
    studentGPA = this.getGPAData();
  }

  // * Use insertion algorithm to sort the map by value.
  // * Insertion algorithm is implemented on two steps: step 2 and step 3
  // * step 2: compare the entry
  // * step 3: insert the entry to a new map based on the comparison
  private Map<String, Double> sortByValue(Map<String, Double> unsortMap) {

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
    Map<String, Double> sortedStudentGPA = sortByValue(this.studentGPA);

    if (k <= sortedStudentGPA.size()) {
      lowestKGPA = sortedStudentGPA.entrySet().stream()
          .limit(k)
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      return lowestKGPA;
    } else {
      return null;
    }

  }


  @Override
  public void displayLowestKGPA() {
    Map<String, Double> sortedLowestStudentGPA = sortByValue(lowestKGPA);
    sortedLowestStudentGPA.entrySet().forEach(gpa -> {
      System.out.println(gpa.getKey() + ": " + gpa.getValue());
    });
  }



}
