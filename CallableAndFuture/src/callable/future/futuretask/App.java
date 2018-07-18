package callable.future.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService es = Executors.newCachedThreadPool();
    CallableTread ct = new CallableTread();
    Future<String> f = es.submit(ct);
    
    Thread.sleep(5000);
    System.out.println("Main thread waits for 5s, now time is " + System.currentTimeMillis());
    
      try {
        String str = f.get();
        System.out.println("Future data is get, str = " + str + ", now time is " + System.currentTimeMillis());
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    
    
  }

}
