package assignment2;

/*
 * 
 */
public class LinkedList<T> {
  protected Link<T> first;
  private int numOfElem = 0;
  private static int count = 0;

  // constructor
  public LinkedList() {
    first = null;
  }

  public int getNumOfElem() {
    return this.numOfElem;
  }

  protected void incrementNumOfElem() {
    numOfElem++;
  }

  protected void decrementNumOfElem() {
    numOfElem--;
  }

  // isEmpty
  public boolean isEmpty() {
    return first == null;
  }

  // insert AT LAST!!
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

    // increment numOfElem
    numOfElem++;
  }

  /*
   * Remove the first element and return the value
   *
   */
  public Link<T> remove() {
    Link<T> current = first;

    first = first.next;
    numOfElem--;
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

  /*
   * count recursively will destroy the linked list So backup the list before countRecur
   */
  public int countRecur(Link<T> list) {
    if (list == null) {
      return count;
    } else {
      count++;
    }

    return countRecur(list.next);
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
