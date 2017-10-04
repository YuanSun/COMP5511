package assignment2;

public class DoubleLinkedList<T> {
  protected DoubleLink<T> first;
  protected DoubleLink<T> last;
  private int numOfElem = 0;

  public DoubleLinkedList() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  // Insert at FIRST
  public void insert(T dd) {
    DoubleLink<T> newLink = new DoubleLink<T>(dd);

    if (isEmpty()) {
      last = newLink;
    }
    newLink.next = first;
    first = newLink;

    numOfElem++;
  }

  /*
   * Insert at LAST NEED TO FIX
   */
  public void insertLast(T dd) {
    DoubleLink<T> newLink = new DoubleLink<T>(dd); // make a new link
    DoubleLink<T> previous = null;
    DoubleLink<T> current = first;

    while (current != null) {
      previous = current;
      current = (DoubleLink<T>) current.next; // go to the next item
    }

    if (previous == null) { // at beginning of list
      first = newLink;
      newLink.previous = null;
    } else {
      newLink.previous = previous;
      previous.next = newLink;
    }

    newLink.next = current;

    numOfElem++;
  }

  public DoubleLink<T> remove() {
    DoubleLink<T> current = first;

    first = (DoubleLink<T>) first.next;
    numOfElem--;
    return current;
  }

  // remove fromt last
  public DoubleLink<T> removeLast() {
    DoubleLink<T> current = first;
    DoubleLink<T> previous = null;
    while (current != last) {
      previous = current;
      current = (DoubleLink<T>) current.next;
    }

    previous.next = null;
    last = previous;
    numOfElem--;
    return current;
  }

  public void displayList() {
    System.out.println("List (first --> last): ");
    DoubleLink<T> current = first;

    while (current != null) {
      current.displayLink();
      current = (DoubleLink<T>) current.next;
    }
    System.out.println("");
  }
}
