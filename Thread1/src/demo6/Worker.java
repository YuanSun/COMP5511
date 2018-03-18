package demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
  private Random random = new Random();
  
  private Object lock1 = new Object(); // more practical to declare separate lock objects
  private Object lock2 = new Object();
  
  private List<Integer> list1 = new ArrayList<>();
  private List<Integer> list2 = new ArrayList<>();
  
  public void stageOne() throws InterruptedException { // intrinsic lock is on the object worker if using synchronized keyword
    synchronized (lock1) {
      Thread.sleep(1);
      list1.add(random.nextInt(100));
    }
  }
  
  public synchronized void stageTwo() throws InterruptedException {
    synchronized (lock2) {
      Thread.sleep(1);
      list2.add(random.nextInt(100));   
    }
  }
  
  
  public void process() throws InterruptedException { 
    for (int i = 0; i < 1000; i++) {
      stageOne();
      stageTwo();
    }
  }
  
  public void main() throws InterruptedException {
    System.out.println("Start...");
    
    long start = System.currentTimeMillis();
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        try {
          process();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        try {
          process();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    
    t1.start();
    t2.start();
    
    t1.join();
    t2.join();
    
    
    long end = System.currentTimeMillis();
    
    System.out.println("Time take: " + (end - start));
    System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
  }
}
