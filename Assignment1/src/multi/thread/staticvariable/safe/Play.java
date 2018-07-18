package multi.thread.staticvariable.safe;

import java.util.Random;

public class Play {
  public static int number;
  public static final int N = 101;

  public Play() {
    number = 0;
  }

  public synchronized void incrementNumber() throws InterruptedException {
    Random random = new Random();
    for (int i = 0; i < N; i++) {
      // Thread.sleep(random.nextInt(50));
      ++number;
    }
  }

  public synchronized void decrementNumber() {
    for (int i = 0; i < N; i++) {
      --number;
    }
  }

  public int getNumber() {
    return number;
  }
}
