package assignment3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public interface Q4 {
  default public Map<String, Double> getGPAData() throws FileNotFoundException {
    String GAPFILE = "RandomGPA.txt";
    Map<String, Double> studentGPA = new HashMap<>();
    BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(GAPFILE)));

    try {
      String line;
      while ((line = br.readLine()) != null) {
        String delimiter = ":";
        String name = line.substring(0, line.indexOf(delimiter));
        Double gpa = Double.valueOf(line.substring(line.indexOf(delimiter) + 1));
        studentGPA.put(name, gpa);
      }
    } catch (NumberFormatException | IOException e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return studentGPA;
  }

  public Map<String, Double> findLowestGPAs(int k);

  public void displayLowestKGPA();
}
