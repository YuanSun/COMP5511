package assignment2;

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
    DoubleLinkedList<Integer> dlinkedList = new DoubleLinkedList<>();
    dlinkedList.insert(new DoubleLink<Integer>(13));
    dlinkedList.insert(new DoubleLink<Integer>(16));
    dlinkedList.insert(new DoubleLink<Integer>(18));
    dlinkedList.insert(new DoubleLink<Integer>(20));

    dlinkedList.displayList();

    dlinkedList.insertLast(new DoubleLink<Integer>(25));
    dlinkedList.displayList();

    LinkStack<Integer> stack = new LinkStack<Integer>();
    while (!dlinkedList.isEmpty()) {
      stack.push(dlinkedList.remove());
    }

    while (!stack.isEmpty()) {
      dlinkedList.insert(stack.pop());
    }

    System.out.println("\nAfter reverse order:");
    dlinkedList.displayList();
  }

}
