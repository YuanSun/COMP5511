package assignment3;

import java.io.FileNotFoundException;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    int k = 20;
    Q4 q4 = new Q4SortedList();

    q4.findLowestGPAs(k);
    q4.displayLowestKGPA();
  }

}
