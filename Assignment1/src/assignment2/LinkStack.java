package assignment2;

public class LinkStack<T> {
  private DoubleLinkedList<T> stackList;

  public LinkStack() {
    stackList = new DoubleLinkedList<>();
  }

  public void push(DoubleLink<T> dd) {
    stackList.insert(dd);
  }

  public DoubleLink<T> pop() {
    return stackList.removeLast();
  }

  public DoubleLink<T> peak() {
    return stackList.first;
  }

  public boolean isEmpty() {
    return (stackList.getNumOfElem() == 0);
  }
}
