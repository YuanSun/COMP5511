package multi.thread.sync;

public class Sync {
  public void test() {
    synchronized (Sync.class) {
      System.out.println("Thread " + Thread.currentThread().getId() + ": test开始..");
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      System.out.println("Thread " + Thread.currentThread().getId() +": test结束..");
      }
  }
}
