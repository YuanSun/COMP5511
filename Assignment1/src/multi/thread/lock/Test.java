package multi.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
  private ArrayList<Integer> arrayList = new ArrayList<Integer>();
  private Lock lock = new ReentrantLock(); // 注意这个地方：lock 被声明为成员变量
  public static void main(String[] args) {
    final Test test = new Test();

    new Thread("A") {
        public void run() {
          test.insert(Thread.currentThread());
        };
    }.start();

    new Thread("B") {
        public void run() {
            test.insert(Thread.currentThread());
        };
    }.start();
  }

  public void insert(Thread thread) {
//    Lock lock = new ReentrantLock();  // 注意这个地方:lock被声明为局部变量
    if(lock.tryLock()) {
      try {
          System.out.println("线程" + thread.getName() + "得到了锁...");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          
          for (int i = 0; i < 5; i++) {
              arrayList.add(i);
          }
      } catch (Exception e) {
  
      } finally {
          System.out.println("线程" + thread.getName() + "释放了锁...");
          lock.unlock();
      }
    } else {
      System.out.println("线程" + thread.getName() + "获取锁失败...");
    }
}
}
