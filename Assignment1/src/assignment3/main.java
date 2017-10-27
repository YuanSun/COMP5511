package assignment3;

import java.io.FileNotFoundException;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    int k = 20;
    Q4 q4 = new Q4SortedList();

    // q4.findLowestGPAs(k);
    // q4.displayLowestKGPA();

    Heap<String, Double> heap = new Heap<>();
    heap.add("John", 3.23);
    heap.add("Helan", 4.35);
    heap.add("Joen", 4.33);
    heap.add("Jack", 1.02);
    heap.add("Shred", 2.34);
    heap.add("Gray", 3.76);
    heap.add("Bob", 4.00);
    heap.displayHeap();
  }

}
