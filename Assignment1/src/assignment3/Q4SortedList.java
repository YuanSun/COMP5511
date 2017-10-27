package assignment3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Q4SortedList implements Q4 {
  private Map<String, Double> studentGPA = new HashMap<>();
  private ArrayList<Map.Entry<String, Double>> lowestKGPA = new ArrayList<>();

  public Q4SortedList() throws FileNotFoundException {
    studentGPA = this.getGPAData();
  }

  // * Use insertion algorithm to sort the map by value.
  private ArrayList<Entry<String, Double>> sortByValue(Map<String, Double> unsortMap) {

    // 1. Convert Map to List of Map Entry
    ArrayList<Map.Entry<String, Double>> list =
        new ArrayList<Map.Entry<String, Double>>(unsortMap.entrySet());

    // 2. Sort the list with Selection Sort
    ArrayList<Map.Entry<String, Double>> sortedList = selectionSort(list);
    
    return sortedList;
  }

  
  private ArrayList<Entry<String, Double>> selectionSort(ArrayList<Entry<String, Double>> list) {
    int length = list.size();
    
    for (int i = 0; i < length; i++) {
      for (int j = i; j > 0; j --) {
        if(list.get(j).getValue().compareTo(list.get(j-1).getValue()) < 0) {
          Collections.swap(list, j, j-1);
        }
      }
    }
    
    return list;
  }

  @Override
  public ArrayList<Entry<String, Double>> findLowestGPAs(int k) {
    ArrayList<Entry<String, Double>> sortedStudentGPA = sortByValue(this.studentGPA);

    if (k <= sortedStudentGPA.size()) {
      lowestKGPA = (ArrayList<Entry<String, Double>>) sortedStudentGPA.stream().limit(k)
          .collect(Collectors.toList());
         
          
      return lowestKGPA;
    } else {
      return null;
    }

  }


  @Override
  public void displayLowestKGPA() {
    lowestKGPA.stream().forEach(gpa -> {
      System.out.println(gpa.getKey() + ": " + gpa.getValue());
    });
  }



}
