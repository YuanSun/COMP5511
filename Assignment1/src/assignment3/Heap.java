package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/*
 * Min heap implementation
 */


public class Heap<K, V> extends ArrayList<Map.Entry<String, Double>> {

  /**
   * 
   */
  private static final long serialVersionUID = 891686786230457490L;

  public Heap() {
    super();
  }

  public Map.Entry<String, Double> ROOT() {
    return this.get(0);
  }

  public Map.Entry<String, Double> PARENT(Map.Entry<String, Double> node) {
    if (this.indexOf(node) == 0) {
      return this.get(0);
    }
    return this.get((indexOf(node) - 1) / 2);
  }

  public Map.Entry<String, Double> LEFT(Map.Entry<String, Double> T) {
    return this.get(indexOf(T) * 2 + 1);
  }

  public Map.Entry<String, Double> RIGHT(Map.Entry<String, Double> T) {
    return this.get(indexOf(T) * 2 + 2);
  }

  // ------------------------------------------------------------------------------
  // Here the node at index i and its two direct children violates the heap property
  private void trickleDown(int index) {
    Map.Entry<String, Double> smallest;
    Map.Entry<String, Double> top = this.get(index);
    int currentSize = this.size();

    while (index < currentSize / 2) { // while node has at leat one child
      Map.Entry<String, Double> left = LEFT(this.get(index));
      Map.Entry<String, Double> right = RIGHT(this.get(index));

      // find smaller child
      // if right child exists
      if (right != null && left.getValue().compareTo(right.getValue()) > 0) {
        smallest = right;
      } else {
        smallest = left;
      }

      // top <= smallest ?
      if (top.getValue().compareTo(smallest.getValue()) <= 0) {
        break;
      }

      // shift child up
      int smallestIndex = this.indexOf(smallest);
      Collections.swap(this, index, smallestIndex);
      index = smallestIndex;
    } // end while
  }

  // ------------------------------------------------------------------
  // trickleUp-- make the tree satisfy MinHeap condition
  private void trickleUp(int index) {
    Map.Entry<String, Double> bottom = this.get(index);

    // if bottom < parent, move up
    while (PARENT(bottom).getValue().compareTo(bottom.getValue()) > 0) {
      Collections.swap(this, this.indexOf(bottom), this.indexOf(PARENT(bottom)));
    }

  }

  // -----------------------------------------------------------------
  public boolean change(int index, Map.Entry<String, Double> newEntry) {
    if (index < 0 || index >= this.size()) {
      return false;
    }

    Map.Entry<String, Double> oldEntry = this.get(index);
    this.add(index, newEntry);

    if (oldEntry.getValue().compareTo(newEntry.getValue()) < 0) {
      trickleUp(index);
    } else {
      trickleDown(index);
    }

    return true;


  }

  // -------------------------------------------------------------------
  public boolean add(Map.Entry<String, Double> e) {
    // add the node to the heap, then trickleDown
    super.add(e);
    trickleUp(this.indexOf(e));
    return true;
  }

  // ---------------------------------------------------------------------
  // pop the root
  public Map.Entry<String, Double> removeRoot() {
    Collections.swap(this, 0, this.size() - 1);
    Map.Entry<String, Double> root = this.remove(this.size() - 1);
    trickleDown(0);
    return root;
  }

  // -------------------------------------------------------------------------
  public void displayHeap() {
    this.forEach(entry -> {
      System.out.println(this.indexOf(entry) + ": " + entry.getKey() + ": " + entry.getValue());
    });
  }

}
