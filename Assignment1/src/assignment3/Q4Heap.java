package assignment3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class Q4Heap implements Q4 {
  private Heap<String, Double> studentGPAMinHeap = new Heap<>();
  private ArrayList<Map.Entry<String, Double>> lowestKGPA = new ArrayList<>();

  public Q4Heap() throws FileNotFoundException {
    Map<String, Double> studentGPA = this.getGPAData();
    studentGPA.entrySet().forEach(gpa -> {
      studentGPAMinHeap.add(gpa);
    });
  }

  @Override
  public ArrayList<Map.Entry<String, Double>> findLowestGPAs(int k) {
    for (int i = 0; i < k; i++) {
      Map.Entry<String, Double> e = studentGPAMinHeap.removeRoot();
      lowestKGPA.add(e);
    }
    return lowestKGPA;
  }

  @Override
  public void displayLowestKGPA() {
    lowestKGPA.forEach(gpa -> {
      System.out.println(gpa.getKey() + ": " + gpa.getValue());
    });
  }

  public void peakRoot() {
    System.out.println(studentGPAMinHeap.ROOT().getKey() + ": " + studentGPAMinHeap.ROOT().getValue());
  }

}
