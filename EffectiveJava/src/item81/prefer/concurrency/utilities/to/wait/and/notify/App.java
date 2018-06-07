package item81.prefer.concurrency.utilities.to.wait.and.notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

  public static void main(String[] args) throws InterruptedException {
    int PLAYER_AMOUNT = 5;
    ExecutorService executor = Executors.newFixedThreadPool(PLAYER_AMOUNT);
    long runningTime = Timer.time(executor, PLAYER_AMOUNT, new Runnable() {
      public void run() {
        try {
          System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
          Thread.sleep(3000);
          System.out.println("Thread " + Thread.currentThread().getName() + " complete");
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    });
    
    System.out.println("Total running time is " + runningTime / 1000000000.0 + " seconds");

  }

}
