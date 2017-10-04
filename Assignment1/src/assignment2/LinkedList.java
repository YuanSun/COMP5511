package assignment2;

/*
 * 
 */
public class LinkedList<T> {
  private Link<T> first;

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
