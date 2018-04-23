package spiralMatirx;

import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    int n = 5;
    ArrayList<ArrayList<Integer>> result = SpiralMatrix.matrix(n);
    for (int i = 0; i < n; i ++) {
      System.out.println(result.get(i));
    }
    

  }

}
