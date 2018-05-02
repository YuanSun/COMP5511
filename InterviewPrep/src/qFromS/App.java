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

    StackQueue queue = new StackQueue();
    queue.addAll(theList);
  }

}
