package qFromS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stack<E> {
  private List<E> data;

  public Stack() {
    data = new ArrayList<>();
  }

  public void push(E e) {
    data.add(e);
  }

  public E pop() {
    return data.remove(0);
  }

  public boolean isEmpty() {
    return data.isEmpty();
  }

  public E peak() {
    return data.get(0);
  }

  public void pushAll(Iterable<? extends E> src) {
    while (src.iterator().hasNext()) {
      data.add(src.iterator().next());
    }
  }

  public void popAll(Collection<? super E> dst) {
    while (!data.isEmpty()) {
      dst.add(data.remove(0));
    }
  }

  public Iterable<E> popAll() {
    return data;


  }
}
