package assignment2;

public class FirstLastLinkedList<T> extends LinkedList<T> {
  private Link<T> last;

  public FirstLastLinkedList() {
    super();
    last = null;
  }

  /**
   * Insert AT FIRST !!
   */
  @Override
  public void insert(T dd) {
    Link<T> newLink = new Link<T>(dd);

    if (isEmpty()) {
      last = newLink;
    }
    newLink.next = first;
    first = newLink;

    incrementNumOfElem();
  }

  public void insertLast(T dd) {
    Link<T> newLink = new Link<T>(dd);

    if (isEmpty()) {
      first = newLink;
    } else {
      last.next = newLink;
    }

    last = newLink;
    incrementNumOfElem();
  }

  public Link<T> removeLast() {
    Link<T> current = first;
    Link<T> previous = null;
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
