package latch.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {
  private static List<BaseHealthChecker> services;
  
  private static CountDownLatch latch;
  
  private ApplicationStartupUtil() {
    
  }
  
  private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
  
  public static ApplicationStartupUtil getInstance() {
    return INSTANCE;
  }
  
  public static boolean checkExternalServices() throws Exception {
    latch = new CountDownLatch(3);
    
    services = new ArrayList<BaseHealthChecker>();
    services.add(new NetworkHealthChecker(latch));
    services.add(new CacheHealthChecker(latch));
    services.add(new DataBaseHealthCheck(latch));
    
    // Start service checkers using executor framework
    ExecutorService executor = Executors.newFixedThreadPool(services.size());
    
    for (final BaseHealthChecker c : services) {
      executor.execute(c);
    }
    
    latch.await();
    
    for (final BaseHealthChecker c: services) {
      if(!c.isServiceUp()) {
        return false;
      }
    }
    return true;
  }
}
