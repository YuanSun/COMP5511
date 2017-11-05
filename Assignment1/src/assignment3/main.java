package assignment3;

import java.io.IOException;

public class main {

  public static void main(String[] args) throws IOException {
     int k = 20;
    
     System.out.println("Question 4-1: ");
     Q4 q4_1 = new Q4SortedList();
    
     q4_1.findLowestGPAs(k);
     q4_1.displayLowestKGPA();
    
     System.out.println("\nQuestion 4-2:");
     Q4 q4_2 = new Q4Heap();
     q4_2.findLowestGPAs(k);
     q4_2.displayLowestKGPA();

    System.out.println("\n\nQuestion 5-1: ");
    Q5 q5_1 = new Q5BinarySearch();
    q5_1.displayResult();

    System.out.println("\n\nQuestion 5-2: ");
    Q5 q5_2 = new Q5Dictionary();
    q5_2.displayResult();
    
    System.out.println("\n\nQuestion 6:");
    Q6 q6 = new Q6HashTable();
    q6.displayResult();
  }

}
