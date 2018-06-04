package item79.avoid.excessive.synchronization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet<E> extends ForwardingSet<E> {

  public ObservableSet(Set<E> s) {
    super(s);
  }
  
  private final List<SetObserver<E>> observers = new ArrayList<>();

  public void addObserver(SetObserver<E> observer) {
    synchronized(observers) {
      observers.add(observer);
    }
  }
  
  public boolean removeObserver(SetObserver<E> observer) {
    synchronized(observers) {
      return observers.remove(observer);
    }
  }
  
  private void notifyElementAdded(E element) {
    // alien method invocation inside synchronization block
//    synchronized(observers) {
//      for(SetObserver<E> observer: observers) {
//        observer.added(this, element);
//      }
//    }
    
    // move alien method outside of synchronized block
    List<SetObserver<E>> snapshot = null;
    synchronized(observers) {
      snapshot = new ArrayList<>(observers);
    }
    for (SetObserver<E> observer: snapshot) {
      observer.added(this, element);
    }
  }
  
  @Override
  public boolean add(E element) {
    boolean added = super.add(element);
    if(added) {
      notifyElementAdded(element);
    }
    
    return added;
  }
  
  @Override 
  public boolean addAll(Collection<? extends E> c) {
    boolean result = false;
    for (E element: c) {
      result |= add(element); // call notifyElementAdded
    }
    return result;
  }
}
