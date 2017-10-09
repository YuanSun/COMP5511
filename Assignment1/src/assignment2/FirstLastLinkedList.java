package assignment2;

public class FirstLastLinkedList<T> extends LinkedList<T> {
  private SingleLink<T> last;

  public FirstLastLinkedList() {
    super();
    last = null;
  }

  /**
   * Insert AT FIRST !!
   */
  @Override
  public void insert(T dd) {
    SingleLink<T> newLink = new SingleLink<T>(dd);

    if (isEmpty()) {
      last = newLink;
    }
    newLink.next = first;
    first = newLink;

    incrementNumOfElem();
  }

  public void insertLast(T dd) {
    SingleLink<T> newLink = new SingleLink<T>(dd);

    if (isEmpty()) {
      first = newLink;
    } else {
      last.next = newLink;
    }

    last = newLink;
    incrementNumOfElem();
  }

  public SingleLink<T> removeLast() {
    SingleLink<T> current = first;
    SingleLink<T> previous = null;
    while (current != last) {
      previous = current;
      current = current.next;
    }

    previous.next = null;
    last = previous;
    decrementNumOfElem();
    return current;
  }
}
