package multi.thread.testvolatile;

import java.util.concurrent.CountDownLatch;

public class App {

  public static void main(String[] args) {
    Play play = new Play();

    int N = 20;
    CountDownLatch latch = new CountDownLatch(N);
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        play.incrementNumber();
        latch.countDown();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        play.incrementNumber();
        latch.countDown();
      }
    });

    for (int i = 0; i < N / 2; i++) {
      new Thread(t1, "Thread-" + i).start();
      new Thread(t2, "Thread-" + i).start();
    }

    try {
      latch.await();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("\n\nFinal Result: number is " + play.getNumber());
  }

}
