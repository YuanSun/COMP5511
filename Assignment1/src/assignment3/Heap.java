package assignment3;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
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

  // Here the node at index i and its two direct children violates the heap property
  public void trickleDown(int i) {
    Map.Entry<String, Double> smallest;
    Map.Entry<String, Double> top = this.get(i);
    int currentSize = this.size();

    while (i < currentSize / 2) {
      Map.Entry<String, Double> left = LEFT(this.get(i));
      Map.Entry<String, Double> right = RIGHT(this.get(i));

      // find smaller child
      // if right child exists
      if (left.getValue().compareTo(right.getValue()) > 0) {
        smallest = right;
      }
    }

  }

  public boolean add(String key, Double value) {
    Map.Entry<String, Double> e = new SimpleEntry<String, Double>(key, value);

    // add the node to the heap, then trickleDown
    return this.add(e);
  }



}
