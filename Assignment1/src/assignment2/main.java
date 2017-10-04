package assignment2;

public class main {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    linkedList.insert(12);
    linkedList.insert(15);
    linkedList.insert(17);
    linkedList.insert(19);


    linkedList.displayList();
    System.out.println("Count iterately, the linked list has " + linkedList.countItr() + " element(s).");
    System.out.println("Count recursively, the linked list has " + linkedList.countRecur(linkedList.getLink()) + " element(s).");
  }

}
