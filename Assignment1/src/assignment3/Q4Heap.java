package assignment3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class Q4Heap implements Q4 {
  private ArrayList<Map.Entry<String, Double>> studentGPAMinHeap = new ArrayList<>();
  private ArrayList<Map.Entry<String, Double>> lowestKGPA = new ArrayList<>();
  
  public Q4Heap() throws FileNotFoundException {
    Map<String, Double> studentGPA = this.getGPAData();
    studentGPA.entrySet().forEach(gpa -> {
      studentGPAMinHeap.add(gpa);
    });
  }

  
  @Override
  public Map<String, Double> findLowestGPAs(int k) {

    return null;
  }

  @Override
  public void displayLowestKGPA() {


  }

}
