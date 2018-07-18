package item18.favor.composition.over.inheritance;

public class Printer {
  private People people;
  public void Printer(People people) {
    people = people;
  }
  public void print(Callback callback, String text) {
    System.out.println("Printing");
    
    try {
      Thread thread = Thread.currentThread();
      System.out.println(text);
      thread.sleep(3000);
    } catch (Exception e) {
      e.getStackTrace();
    }
    
    callback.printFinished("Finished printing");
    callback.writeResult(people, "CV --->  Name : Ryan Sun");
  }
}
