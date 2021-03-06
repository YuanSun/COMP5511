package latch.example;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker {

  public NetworkHealthChecker(CountDownLatch latch) {
    super("Network Service", latch);
  }
  @Override
  public void verifyService() {
    System.out.println("Checking " + this.getServiceName());

    Random num = new Random();
    try {
      Thread.sleep(num.nextInt(7000)); // simulate Health checking
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getServiceName() + " is UP");
  }

}
