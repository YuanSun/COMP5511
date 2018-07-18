package item18.favor.composition.over.inheritance;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
  // number of attempted element insertions
  private int addCount = 0;
  
  public InstrumentedHashSet() {
    
  }
  
  public InstrumentedHashSet(int initCap, float loadFactor) {
    super(initCap, loadFactor);
  }
  
  @Override 
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }
  
  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c); // broken, call collection.add
  }
  
  public int getAddCount() {
    return addCount;
  }
}
