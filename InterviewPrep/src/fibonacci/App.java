package fibonacci;

import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    ArrayList<Integer> series = new ArrayList<>();
    
    int n = 7;
    
    for(int i = 1; i <= n; i++) {
      series.add(Fibonacci.fib(i));
    }

    System.out.println(series);
  }

}
