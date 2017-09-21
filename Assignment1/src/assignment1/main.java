package assignment1;

public class main {

  public static void main(String[] args) {
    int size = 2000;
    Q5 solution = new Q5(size);

    boolean searchRandomList = true;
    int target = 1500;

    search(solution, target, searchRandomList);
  }

  public static void search(Q5 solution, int target, boolean searchRandomList) {
    if (solution.binarySearch(target, searchRandomList))
      System.out.println(target + " is found.");
    else
      System.out.println("No result is found.");
  }

}
