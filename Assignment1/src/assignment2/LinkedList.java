package assignment2;

/*
 * 
 */
public class LinkedList<T> {
  private Link<T> first;

  private static int count = 0;

  // constructor
  public LinkedList() {
    first = null;
  }

  // getter
  public Link<T> getLink() {
    return first;
  }

  // isEmpty
  public boolean isEmpty() {
    return first == null;
  }

  // insert
  public void insert(T dd) {
    Link<T> newLink = new Link<T>(dd); // make a new link
    Link<T> current = first;
    Link<T> previous = null;

    while (current != null) {
      previous = current;
      current = current.next; // go to the next item
    }

    // empty list
    if (previous == null) {
      first = newLink;
    } else {
      previous.next = newLink;
    }
  }

  /*
   * Pop out the last element and return the value
   * 
   * NEED TO FIX
   */
  public Link<T> pop() {
    Link<T> current = first;
    Link<T> previous = null;
    while (current != null) {
      previous = current;
      current = current.next;
    }

    previous.next = null;
    return current;
  }

  public int countItr() {
    Link<T> current = first;
    int count = 0;

    while (current != null) {
      count++;
      current = current.next; // go to the next item
    }

    return count;
  }

  public int countRecur(LinkedList<T> list) {
    if (list.first == null) {
      return count;
    } else {
      count++;
    }
    list.pop();

    return countRecur(list);
  }

  // display List
  public void displayList() {
    System.out.println("List (first --> last):");
    Link<T> current = first;
    while (current != null) {
      current.displayLink();
      current = current.next;
    }
    System.out.println("");
  }
}
