package fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    ArrayList<BigInteger> series = new ArrayList<>();
    
    int n = 100;
    
    for(int i = 1; i <= n; i++) {
      series.add(Fibonacci.fib(i));
    }

    series.forEach(num -> {
      System.out.print(num + " ");
    });
  }

}
