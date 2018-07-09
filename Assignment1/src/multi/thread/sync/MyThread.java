package multi.thread.sync;

public class MyThread extends Thread {
  public void run() {
    Sync sync = new Sync();
    sync.test();
}


}
