package example.cnblogs.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread{
  private CyclicBarrier cb;
  private int sleepSecond;
  
  public CyclicBarrierThread(CyclicBarrier cb, int sleepSecond) {
    this.cb = cb;
    this.sleepSecond = sleepSecond;
  }
  
  public void run() {
    try {
      System.out.println(this.getName() + " starts operating");
      Thread.sleep(sleepSecond * 1000);
      System.out.println(this.getName() + " starts waiting, time is now " + System.currentTimeMillis());
      cb.await();
      System.out.println(this.getName() + " ends waiting, time is now " + System.currentTimeMillis());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
