package item18.favor.composition.over.inheritance;

public interface Callback {
  void printFinished(String msg);
  
  void writeResult(People people, String result);
}
