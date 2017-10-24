package assignment2;

public class Q4 {
  private LinkedList<Integer> linkedList = new LinkedList<>();

  public Q4() {
    // insert some integer to construct a single linked list
    linkedList.insert(12);
    linkedList.insert(15);
    linkedList.insert(17);
    linkedList.insert(19);
    linkedList.insert(32);
  }

  public void countLinkedList() {
    System.out.println("Question 4: \n");
    linkedList.displayList();
    System.out.println("Count iterately, the linked list has " + linkedList.countItr() + " element(s).");
    System.out.println("Count recursively, the linked list has " + linkedList.countRecur(linkedList.first) + " element(s).");
  }
}
