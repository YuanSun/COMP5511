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
    dlinkedList.insert(13);
    dlinkedList.insert(16);
    dlinkedList.insert(18);
    dlinkedList.insert(20);

    dlinkedList.displayList();

    dlinkedList.insertLast(25);
    dlinkedList.displayList();

    System.out.println("Remove from first: " + dlinkedList.remove().data);
    dlinkedList.displayList();

    System.out.println("Remove from last: " + dlinkedList.removeLast().data);
    dlinkedList.displayList();
  }

}
