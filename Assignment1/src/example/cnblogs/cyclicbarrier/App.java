package example.cnblogs.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class App {

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(2);
    Runnable runnable = new Runnable() {// task that use CyclicBarier to control
      public void run() {
        System.out.println("All threads in cyclicBarrier's await() activatied, time now is " + System.currentTimeMillis());
//        latch.countDown();
      }
    };
    Random num = new Random();
    CyclicBarrier cb = new CyclicBarrier(3, runnable);
    CyclicBarrierThread thread0 = new CyclicBarrierThread(cb, num.nextInt(10));
    CyclicBarrierThread thread1 = new CyclicBarrierThread(cb, num.nextInt(10));
    CyclicBarrierThread thread2 = new CyclicBarrierThread(cb, num.nextInt(10));
    
    thread0.start();
    thread1.start();
    thread2.start();
    
    System.out.println("Main thread completes.");
    try {
      latch.await();
      System.out.println("Reuse CyclicBarrier");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Reuse CyclicBarrier");
    thread0.start();
    thread1.start();
    thread2.start();
    
    
  }

}
