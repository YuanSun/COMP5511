package qFromS;

import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {
    List<Integer> theList = new ArrayList<>();

    int[] arr = {5, 6, 10, 34, 9, 2, -5, 1, 80};

    for (int n : arr) {
      theList.add(n);
    }

    System.out.print("Original arr is ");
    for (int n : arr) {
      System.out.print(n + " ");
    }

    System.out.println("\n");
    StackQueue<Integer> queue = new StackQueue<>();
    queue.addAll(theList);
    queue.add(90);
    queue.add(100);

    // to see what is in the queue by removing all elements
    List<Integer> result = new ArrayList<>();
    queue.removeAll(result);

    System.out.print("The queue results are ");
    result.forEach(e -> {
      System.out.print(e + " ");
    });

    // try with stack
    Stack<Integer> stack = new Stack<>();
    for (int n : arr) {
      stack.push(n);
    }

    stack.push(90);
    stack.push(100);
    result.clear();

    stack.popAll(result);
    System.out.print("\n\nThe stack results are ");
    result.forEach(e -> {
      System.out.print(e + " ");
    });

  }

}
