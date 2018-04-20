package printSteps;

public class Steps {

  static void printSteps(int n) {
    for (int row = 0; row < n; row ++) {
      String stair = "";
      for (int col = 0; col < n; col ++) {
        if (col <= row) {
          stair = stair.concat("#");
        } else {
          stair = stair.concat("-");
        }
      }
      System.out.println(stair); // output the stair
    }
  }
  
  static void printStepsRecur(int n) {
    printRecur(n, 0, "");
  }
  
  static void printRecur(int n, int row, String stair) {
  //think base case / exiting case first to avoid infinite recursion.
    if (n == row) {
      return;
    }
    
    if(n == stair.length()) {
      System.out.println(stair);
      printRecur(n, row + 1, "");
      return; // this return is prevent the program proceed the next line;
    }
    
    String add = stair.length() <= row ? "#" : "-";
    
    printRecur(n, row, stair.concat(add));
  }
}
