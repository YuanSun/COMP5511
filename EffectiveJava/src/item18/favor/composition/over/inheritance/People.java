package item18.favor.composition.over.inheritance;

public class People {
  Printer printer = new Printer();
  private String callbackResult;
  
  // Synchronized callback
  public void goToPrintSync(Callback callback, String text) {
    printer.print(callback, text);
  }
  
  // Asynchronized callback
  public void goToPrintAsync(Callback callback, String text) {
    new Thread(new Runnable() {
      public void run() {
        printer.print(callback, text);
      }
    }).start();
  }
  
  public void writeResult(String result) {
    callbackResult = result;
    System.out.println(callbackResult);
  }
}
