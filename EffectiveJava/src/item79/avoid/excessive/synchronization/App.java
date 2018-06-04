package item79.avoid.excessive.synchronization;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

  public static void main(String[] args) {
    ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
    
    set.addObserver((s, e) -> System.out.println(e)); // This lambda is ok
    
    // will cause ConcurrentModificationException if alien method invocation exists
    set.addObserver(new SetObserver<Integer>() {
      public void added(ObservableSet<Integer>s, Integer e) {
        System.out.println(e);
        if(e == 23) {
          s.removeObserver(this);
        }
      }
    });
    
    // will case deadlock if aliean method invocation exists
    set.addObserver(new SetObserver<Integer>() {
      public void added(ObservableSet<Integer> s, Integer e) {
        System.out.println(e);
        if (e == 23) {
          ExecutorService exec = Executors.newSingleThreadExecutor();
          try {
            exec.submit(() -> s.removeObserver(this)).get();
          } catch (ExecutionException | InterruptedException ex) {
            throw new AssertionError(ex);
          } finally {
            exec.shutdown();
          }
        }
      }
    });

    for (int i = 0; i < 100; i++) {
      set.add(i);
    }
  }

}
