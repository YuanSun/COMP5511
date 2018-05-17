package qFromS;

import java.util.Collection;

// --- Directions
// Implement a Queue datastructure using two stacks.
// *Do not* create an array inside of the 'Queue' class.
// Queue should implement the methods 'add', 'remove', and 'peek'.
// For a reminder on what each method does, look back
// at the Queue exercise.
// --- Examples
// const q = new Queue();
// q.add(1);
// q.add(2);
// q.peek(); // returns 1
// q.remove(); // returns 1
// q.remove(); // returns 2

public class StackQueue<E> {
  private Stack<E> topStack;
  private Stack<E> bottomStack;

  public StackQueue() {
    topStack = new Stack<>();
    bottomStack = new Stack<>();
  }

  public void add(E e) {
    topStack.push(e);
  }

  public E peek() {
    if (bottomStack.isEmpty()) {
      bottomStack.pushAll(topStack.popAll());
    }

    return bottomStack.peak();
  }

  public E remove() {
    if (bottomStack.isEmpty()) {
      bottomStack.pushAll(topStack.popAll());
    }

    return bottomStack.pop();
  }

  public boolean isEmpty() {
    return (topStack.isEmpty() && bottomStack.isEmpty());
  }

  public void addAll(Iterable<? extends E> src) {
    topStack.pushAll(src);
  }

  public void removeAll(Collection<? super E> dst) {
    if (!bottomStack.isEmpty()) {
      bottomStack.popAll().forEach(e -> {
        dst.add(e);
      });
    }

    if (!topStack.isEmpty()) {
      bottomStack.pushAll(topStack.popAll());
      bottomStack.popAll().forEach(e -> {
        dst.add(e);
      });
    }
  }
}
