package multi.thread.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
  private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  
  public static void main(String[] args)  {

    final Test test = new Test();

    new Thread("A"){
        public void run() {
            test.get(Thread.currentThread());
        };
    }.start();

    new Thread("B"){
        public void run() {
            test.get(Thread.currentThread());
        };
    }.start();

  }  

  public void get(Thread thread) {
    rwl.readLock().lock();
    try {
      long start = System.currentTimeMillis();
      System.out.println("线程"+ thread.getName()+"开始读操作...");
      while(System.currentTimeMillis() - start <= 10) {
          System.out.println("线程"+ thread.getName()+"正在进行读操作...");
      }
    System.out.println("线程"+ thread.getName()+"读操作完毕...");
    } finally {
      rwl.readLock().unlock();
    }
  }
}
