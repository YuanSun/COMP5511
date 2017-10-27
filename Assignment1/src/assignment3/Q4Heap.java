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

  public Map.Entry<String, Double> root() {
    return studentGPAMinHeap.get(0);
  }

  public Map.Entry<String, Double> leftChild(Map.Entry<String, Double> node) {
    return studentGPAMinHeap.get(studentGPAMinHeap.indexOf(node) * 2 + 1);
  }

  public Map.Entry<String, Double> rightChild(Map.Entry<String, Double> node) {
    return studentGPAMinHeap.get(studentGPAMinHeap.indexOf(node) * 2 + 2);
  }



  @Override
  public Map<String, Double> findLowestGPAs(int k) {

    return null;
  }

  @Override
  public void displayLowestKGPA() {


  }

}
