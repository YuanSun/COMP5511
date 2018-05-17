package threadServcie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Runnable task1 = () -> {
      System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
      try {
          TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException ex) {
          throw new IllegalStateException(ex);
      }
    };
    
    Runnable task2 = () -> {
      System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
      try {
          TimeUnit.SECONDS.sleep(4);
      } catch (InterruptedException ex) {
          throw new IllegalStateException(ex);
      }
    };
    
    executorService.submit(task1);
    executorService.submit(task2);
    executorService.shutdown();
  }
}
