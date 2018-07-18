package callable.future.futuretask;

import java.util.concurrent.Callable;

public class CallableTread implements Callable<String> {

  @Override
  public String call() throws Exception {
    System.out.println("Enter the call() method of CallableThread, start sleeping. Now time is " + System.currentTimeMillis());
    Thread.sleep(10000);
    return "123";
  }

}
