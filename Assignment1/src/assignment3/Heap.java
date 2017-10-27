package assignment3;
/*
 * Min heap implementation
 */
import java.util.ArrayList;

public class Heap<T<Map.Entry<String, Double>> extends Comparable> extends ArrayList<T<Map.Entry<String, Double>>>{
  public Heap () {
    super();
  }
  
  public T ROOT() {
    return this.get(0);
  }
  
  public T PARENT(T node) {
    if(this.indexOf(node) == 0) {
      return this.get(0);
    }
    return this.get((indexOf(node) - 1) / 2); 
  }
  
  public T LEFT(T node) {
    return this.get(indexOf(node) * 2 + 1);
  }
  
  public T RIGHT(T node) {
    return this.get(indexOf(node) * 2 + 2);
  }
  
  // Here the node at index i and its two direct children violates the heap property
  public void trickleDown(int i) {    
    T smallest;
    T top = this.get(i);
    int currentSize = this.size();
    
    while(i < currentSize / 2) {
      T left = LEFT(this.get(i));
      T right = RIGHT(this.get(i));
      
      // find smaller child
      // if right child exists
      if(this.indexOf(right) < currentSize && left.compareTo(right) > 0) {
        smallest = right;
      }
    }
    
  }
  
}
