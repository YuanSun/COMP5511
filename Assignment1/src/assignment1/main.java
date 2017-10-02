package assignment1;

import java.util.Arrays;

public class main {

  public static void main(String[] args) {
    // Question 5
    int sizeQ5 = 1990;
    boolean normalSizeForTestList = true;
    boolean normalRangeForRandomList = true;
    final String SEARCHTIME = "SearchTime";
    Q5 solutionQ5 = new Q5(sizeQ5, normalRangeForRandomList, normalSizeForTestList);

    boolean searchRandomList = true;
    int target = 1980;
    System.out.println("Question 5\nTarget is " + target);
    long startTime = System.nanoTime();
    search(solutionQ5, target, searchRandomList);
    long estimatedTime = System.nanoTime() - startTime;

    System.out.println("Time used : " + estimatedTime + " nano secs");

    long startTime2 = System.nanoTime();
    searchPureBinarySearch(solutionQ5, target);
    long estimatedTime2 = System.nanoTime() - startTime2;

    System.out.println("Pure binary search : " + estimatedTime2 + " nano secs");

    // Question 6
    int sizeQ6 = 20;
    Q6 solutionQ6 = new Q6(sizeQ6);
    System.out.println("\nQuestion 6");
    solutionQ6.sortArrA();

  }

  public static void search(Q5 solution, int target, boolean searchRandomList) {
    if (solution.binarySearch(target, searchRandomList)) {
      System.out.println(target + " is found.");
      System.out.println("Found at position " + solution.result.get("FoundAtPosition"));
    } else
      System.out.println("No result is found.");
  }

  public static void searchPureBinarySearch(Q5 solution, int target) {
    int k = solution.pureBinarySearch(target);

    if (k >= 0) {
      System.out.println(target + " is found.");
      System.out.println("Found at position " + k);
    } else {
      System.out.println("No result is found.");
    }
  }
}
