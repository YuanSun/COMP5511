package assignment3;

import java.io.IOException;

public class main {

  public static void main(String[] args) throws IOException {
//    int k = 20;
//    
//    System.out.println("Question 4-1: ");
//    Q4 q4_1 = new Q4SortedList();
//
//    q4_1.findLowestGPAs(k);
//    q4_1.displayLowestKGPA();
//
//    System.out.println("\nQuestion 4-2:");
//    Q4 q4_2 = new Q4Heap();
//    q4_2.findLowestGPAs(k);
//    q4_2.displayLowestKGPA();
    
    System.out.println("\n\nQuestion 5-1: ");
    Q5 q5_1 = new Q5BinarySearch();
    q5_1.displayResult();
//    ArrayList<String> data = q5_1.getData();
//    ArrayList<String> keysToSearch = q5_1.getSearchKey();
    // compare the result using embedded functions
//    System.out.println("\nCompare search result with embedded functions");
//    keysToSearch.forEach(key -> {
//      if(data.contains(key)) {
//        System.out.println("Found " + key);
//      } else {
//        System.out.println(key + ": Not found");
//      }
//    });
    System.out.println("\n\nQuestion 6:");
    Q6 q6 = new Q6HashTable();
    q6.displayResult();
    
  }

}
