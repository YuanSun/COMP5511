package multi.thread.staticvariable.safe;

import java.util.concurrent.CountDownLatch;

public class App {

  public static void main(String[] args) throws InterruptedException {
    int N = 60;
    CountDownLatch latch = new CountDownLatch(N);
    Play play = new Play();
    AccessPlay accessPlay = new AccessPlay(new Play());
    Thread threadA = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          play.incrementNumber();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        System.out.println("Number is " + Play.number);
        latch.countDown();
      }
    });

    Thread threadB = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          accessPlay.decrementPlay();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        System.out.println("Number is " + Play.number);
        latch.countDown();
      }
    });

    for (int i = 0; i < N / 2; i++) {
      new Thread(threadA, "Thread-" + i).start();
      new Thread(threadB, "Thread-" + i).start();
    }

    latch.await();

    System.out.println("\n\nFinal result: number is " + Play.number);
  }

}
