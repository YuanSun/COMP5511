package multi.thread.testvolatile;

public class Play {
  private volatile int number = 0;

  public void incrementNumber() {
    number++;
  }

  public int getNumber() {
    return this.number;
  }
}
