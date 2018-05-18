package queueFromStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
    Iterator<? extends E> itr = src.iterator();
    while (itr.hasNext()) {
      data.add(itr.next());
    }
  }

  public void popAll(Collection<? super E> dst) {
    while (!data.isEmpty()) {
      dst.add(data.remove(data.size() - 1));
    }
  }

  public Iterable<E> popAll() {
    Collections.reverse(data);
    return data;
  }
}
