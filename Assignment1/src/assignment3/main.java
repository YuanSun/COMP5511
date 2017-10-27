package assignment3;

import java.io.FileNotFoundException;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    int k = 20;
    Q4 q4_1 = new Q4SortedList();

    q4_1.findLowestGPAs(k);
    q4_1.displayLowestKGPA();

    System.out.println("\n Q 4-2");
    Q4 q4_2 = new Q4Heap();
    // ((Q4Heap) q4_2).peakRoot();
    q4_2.findLowestGPAs(k);
    q4_2.displayLowestKGPA();
  }

}
