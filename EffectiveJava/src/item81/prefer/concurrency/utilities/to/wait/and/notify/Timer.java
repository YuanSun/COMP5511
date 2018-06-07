package item81.prefer.concurrency.utilities.to.wait.and.notify;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class Timer {
  public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
    CountDownLatch ready = new CountDownLatch(concurrency);
    CountDownLatch start = new CountDownLatch(1);
    CountDownLatch done = new CountDownLatch(concurrency);
    
    for (int i = 0; i < concurrency; i++) {
      executor.execute(() -> {
        ready.countDown(); // tell timer we're ready
//        System.out.println("Thread " + Thread.currentThread().getName() + " is ready!");
        try {
          start.await(); // wait till peers are ready
//          System.out.println("Thread " + Thread.currentThread().getName() + " go!");
          action.run();
        } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
        } finally {
          done.countDown(); // Tell timer we're done
        }
      });
    }
    
    ready.await(); // wait for all works to be ready
    long startNanos = System.nanoTime();
    start.countDown(); // and they are off
    done.await(); // wait for all workers to finish
    return System.nanoTime() - startNanos;
  }
}
