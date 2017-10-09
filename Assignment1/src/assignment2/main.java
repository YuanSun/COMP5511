package assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class main {

  public static void main(String[] args) throws IOException {
    
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
    
    System.out.println("\nSorted single linked list is :");
    singleLinkedList.displayList();
    
    Stack<SingleLink<Integer>> stack = new Stack<>();
    while (!singleLinkedList.isEmpty()) {
      stack.push(singleLinkedList.remove());
    }
    
    while(!stack.isEmpty()) {
      singleLinkedList.insert(stack.pop().data);
    }
    
    System.out.println("\nReversed single linked list is :");
    singleLinkedList.displayList();
  
    
    // Question 6
    Q6 q6 = new Q6(); // accept data
    
    // get two copies
    String[] str1 = new String[q6.data.size()]; 
    q6.data.toArray(str1);
    
    String[] str2 = new String[q6.data.size()];
    q6.data.toArray(str2);
    
    // use selection sort on str1, quick sort on str2
    long startTime1 = System.nanoTime();
    Q6.selectionSort(str1);
    long sortTime1 = System.nanoTime() - startTime1;
    
    long startTime2 = System.nanoTime();
    Q6.quickSort(str2);
    long sortTime2 = System.nanoTime() - startTime2;
    
    // check sort results
//    for (int i = 0; i < str1.length; i++) {
//      System.out.println(str1[i] + " - " + str2[i]);
//    }
    
    System.out.println("\nQuestion 6: \nSort time for selection sort is " + (double)sortTime1/1000000 + " mili seconds.\n"
        + "Sort time for quick sort is " + (double)sortTime2/1000000 + " mili seconds.");
  }

}
