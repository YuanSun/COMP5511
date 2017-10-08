package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class main {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    // Question 4
    linkedList.insert(12);
    linkedList.insert(15);
    linkedList.insert(17);
    linkedList.insert(19);
    linkedList.insert(32);

    System.out.println("Question 4: \n");
    linkedList.displayList();
    System.out.println("Count iterately, the linked list has " + linkedList.countItr() + " element(s).");
    System.out.println("Count recursively, the linked list has " + linkedList.countRecur(linkedList.first) + " element(s).");

    // Question 5
    Integer MAXRANGE = 2000;
    int NUMOFELEM = 10;
    ArrayList<Integer> randomArray = new ArrayList<>();
    Random rand = new Random();
    for (int i = 0; i < NUMOFELEM; i++) {
      randomArray.add(rand.nextInt(MAXRANGE));
    }
    
    Collections.sort(randomArray);
    System.out.println("\nQuestion 5:\nSorted integer list is " + randomArray.toString());
    
    LinkedList<Integer> singleLinkedList = new LinkedList<>();
    while(!randomArray.isEmpty()) {
      singleLinkedList.insert(randomArray.remove(0));
    }
    
    System.out.println("Sorted single linked list is :");
    singleLinkedList.displayList();
    
    Stack<SingleLink<Integer>> stack = new Stack<>();
    while (!singleLinkedList.isEmpty()) {
      stack.push(singleLinkedList.remove());
    }
    
    while(!stack.isEmpty()) {
      singleLinkedList.insert(stack.pop().data);
    }
    
    System.out.println("Reversed single linked list is :");
    singleLinkedList.displayList();
  }

}
