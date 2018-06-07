package item81.prefer.concurrency.utilities.to.wait.and.notify;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Writer extends Thread{
  private CyclicBarrier cyclicBarrier;
  public Writer(CyclicBarrier cyclicBarrier) {
      this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {
      System.out.println("线程 "+Thread.currentThread().getName()+" 正在写入数据...");
      try {
          Thread.sleep(5000);      //以睡眠来模拟写入数据操作
          System.out.println("线程 "+Thread.currentThread().getName()+" 写入数据完毕，等待其他线程写入完毕");
          cyclicBarrier.await();
      } catch (InterruptedException  | BrokenBarrierException e) {
          e.printStackTrace();
      }
      System.out.println("所有线程写入完毕，继续处理其他任务...");
  }
}
