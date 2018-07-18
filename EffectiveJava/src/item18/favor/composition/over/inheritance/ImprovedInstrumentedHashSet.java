package item18.favor.composition.over.inheritance;

import java.util.Collection;
import java.util.Set;

public class ImprovedInstrumentedHashSet<E> extends ForwardingSet<E>{
  private int addCount = 0;
  
  public ImprovedInstrumentedHashSet(Set<E> s) {
    super(s);
  }
  
  @Override public boolean add(E e) {
    addCount++;
    return super.add(e);
  }
  
  @Override public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }
  
  public int getAddCount() {
    return addCount;
  }
}
