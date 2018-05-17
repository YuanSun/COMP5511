package fibonacci;

import java.math.BigInteger;
import java.util.HashMap;

//--- Directions
//Print out the n-th entry in the fibonacci series.
//The fibonacci series is an ordering of numbers where
//each number is the sum of the preceeding two.
//For example, the sequence
//[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
//forms the first ten entries of the fibonacci series.
//Example:
//fib(4) === 3
public class Fibonacci {
  
  private static final HashMap<Integer, BigInteger> cache = new HashMap<>();
  
  static BigInteger fib (int n) {
    if(n < 2) {
      cache.put(n, new BigInteger(String.valueOf(n)));
      return new BigInteger(String.valueOf(n));
    }
    
    if(cache.get(n) == null) {
      BigInteger fibValue = fib(n - 1).add(fib(n - 2));
      cache.put(n, fibValue);
      return fibValue;
    } else {
      return cache.get(n);
    }
    
  }
  
  
}
