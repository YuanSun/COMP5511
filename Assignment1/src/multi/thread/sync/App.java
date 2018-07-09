package multi.thread.sync;

public class App {

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
      Thread thread = new MyThread();
      System.out.println("Thread " + thread.getId() + " started");
      thread.start();
  }

  }

}
