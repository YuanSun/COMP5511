package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Q5 {
  private Integer MAXRANGE = 2000;
  private int NUMOFELEM = 10;
  private ArrayList<Integer> randomArray = new ArrayList<>();
  private Random rand = new Random();

  public Q5() {
    for (int i = 0; i < NUMOFELEM; i++) {
      randomArray.add(rand.nextInt(MAXRANGE));
    }

    Collections.sort(randomArray);
    System.out.println("\nQuestion 5:\nSorted integer list is " + randomArray.toString());
  }

  public void reverseLinkedList() {
    LinkedList<Integer> singleLinkedList = new LinkedList<>();
    while (!randomArray.isEmpty()) {
      singleLinkedList.insert(randomArray.remove(0));
    }

    System.out.println("\nSorted single linked list is :");
    singleLinkedList.displayList();

    Stack<SingleLink<Integer>> stack = new Stack<>();
    while (!singleLinkedList.isEmpty()) {
      stack.push(singleLinkedList.remove());
    }

    while (!stack.isEmpty()) {
      singleLinkedList.insert(stack.pop().data);
    }

    System.out.println("\nReversed single linked list is :");
    singleLinkedList.displayList();
  }
}
