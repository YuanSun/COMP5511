package multi.thread.fairlock;

import java.util.concurrent.locks.ReentrantLock;

public class RunFair {
  public static void main(String[] args) throws InterruptedException {
    final Service service = new Service(false);     // 公平锁，设为 true
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("★线程" + Thread.currentThread().getName()
                    + "运行了");
            service.serviceMethod();
        }
    };

    Thread[] threadArray = new Thread[10];
    for (int i = 0; i < 10; i++) 
        threadArray[i] = new Thread(runnable);

    for (int i = 0; i < 10; i++) 
        threadArray[i].start(); 
  }
}

class Service {
  private ReentrantLock lock;
  public Service(boolean isFair) {
      super();
      lock = new ReentrantLock(isFair);
  }
  public void serviceMethod() {
      try {
          lock.lock();
          System.out.println("ThreadName=" + Thread.currentThread().getName()
                  + "获得锁定");
      } finally {
          lock.unlock();
      }
  }
}