package assignment1;

public class main {

  public static void main(String[] args) {

    Q5 solution = new Q5(100000);

    boolean searchRandomList = true;
    int target = 5000;

    System.out.println(solution.theList.displayRandomList());
  }

  public static void search(Q5 solution, int target, boolean searchRandomList) {
    if (solution.binarySearch(target, searchRandomList))
      System.out.println(target + " is found.");
    else
      System.out.println("No result is found.");
  }

}
