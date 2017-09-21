package assignment1;

public class main {

  public static void main(String[] args) {
    // Question 5
    int size = 200000;
    boolean normalSizeForTestList = true;
    boolean normalRangeForRandomList = true;
    final String SEARCHTIME = "SearchTime";
    Q5 solution = new Q5(size, normalRangeForRandomList, normalSizeForTestList);

    boolean searchRandomList = true;
    int target = 1500;
    long startTime = System.nanoTime();
    search(solution, target, searchRandomList);
    long estimatedTime = System.nanoTime() - startTime;

    System.out.println("Time used : " + estimatedTime + " nano secs");

  }

  public static void search(Q5 solution, int target, boolean searchRandomList) {
    if (solution.binarySearch(target, searchRandomList)) {
      System.out.println(target + " is found.");
      System.out.println("Found at position " + solution.result.get("FoundAtPosition"));
    } else
      System.out.println("No result is found.");
  }

}
