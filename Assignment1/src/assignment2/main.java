package assignment2;

import java.util.Stack;

public class main {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    // Question 4
    linkedList.insert(12);
    linkedList.insert(15);
    linkedList.insert(17);
    linkedList.insert(19);


    linkedList.displayList();
    System.out.println("Count iterately, the linked list has " + linkedList.countItr() + " element(s).");
    System.out.println("Count recursively, the linked list has " + linkedList.countRecur(linkedList.first) + " element(s).");

    // Question 5
    Stack<SingleLink<Integer>> stack = new Stack<>();
    while (!linkedList.isEmpty()) {
      stack.push(linkedList.remove());
    }
    
    while(!stack.isEmpty()) {
      linkedList.insert(stack.pop().data);
    }
    
    linkedList.displayList();
  }

}
