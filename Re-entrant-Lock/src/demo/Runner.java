package demo;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
  private int count = 0;
  private Lock lock = new ReentrantLock();
  private Condition cond = lock.newCondition();
  private void increment() {
    for (int i = 0; i < 10000; i++) {
      count++;
    }
  }
  public void firstThread() throws InterruptedException {
    lock.lock();
    System.out.println("Waiting");
    cond.await();
    System.out.println("Waken up");
    try {
      increment();
    } finally {
      lock.unlock();
    }
  }
  
  public void secondThread() throws InterruptedException {
    Thread.sleep(100);
    lock.lock();
    System.out.println("Press the return key");
    new Scanner(System.in).nextLine();
    System.out.println("Got return key!");
    
    cond.signal(); // notify the waiting thread
    
    try {
      increment();
    } finally {
      lock.unlock(); // hand over the control of the lock.
    }
  }
  
  public void finished() {
    System.out.println("Count is " + count);
  }
}
