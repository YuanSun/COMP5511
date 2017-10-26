package assignment3;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Q4SortedList implements Q4 {
  public Map<String, Double> studentGAP = new HashMap<>();

  public Q4SortedList() throws FileNotFoundException {
    studentGAP = this.getGPAData();
  }

  @Override
  public Map<String, Double> findLowestGPAs(int k) {
    // TODO Auto-generated method stub
    return null;
  }

}
