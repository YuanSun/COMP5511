package pyramid;

public class Pyramid {
  static void printPyramid(int n) {
    for (int row = 0; row < n; row ++) {
      String level = "";
      for (int col = 0; col < (n*2-1); col++) {
        if(col < (n*2-1)/2 - row || col > (n*2-1)/2 + row) {
          level = level.concat("-");
        } else {
          level = level.concat("#");
        }
      }
      System.out.println(level);
    }
  }
  
  static void printPyramidRecur(int n) {
    printRecur(n, 0, "");
  }
  
  static void printRecur(int n, int row, String level) {
    if(n == row) {
      return;
    }
    
    if(2*n-1 == level.length()) {
      System.out.println(level);
      printRecur(n, row + 1, "");
      return;
    }
    
    String add = level.length() < (n*2-1)/2 - row || level.length() > (n*2-1)/2 + row ? "-" : "#";
    printRecur(n, row, level.concat(add));
  }
}
