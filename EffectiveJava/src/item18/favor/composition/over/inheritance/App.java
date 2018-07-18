package item18.favor.composition.over.inheritance;

import java.util.ArrayList;
import java.util.HashSet;

public class App {

  public static void main(String[] args) {
    InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
    ArrayList<String> arr = new ArrayList<>();
    arr.add("Snap"); arr.add("Crackle"); arr.add("Pop");
    
    s.addAll(arr);
    System.out.println(s.getAddCount());
    
    ImprovedInstrumentedHashSet<String> newSet = new ImprovedInstrumentedHashSet(new HashSet<String>());
    newSet.addAll(arr);
    System.out.println("AddCount is " + newSet.getAddCount());

    
    System.out.println("\n\n ---- Callback Example ----");
    People people = new People();
    Callback callback = new Callback() {
      @Override
      public void printFinished(String msg) {
        System.out.println("Message from printer ----> " + msg);
      }

      @Override
      public void writeResult(People people, String result) {
        people.writeResult(result);
        
      }
      
    };
    
    people.goToPrintAsync(callback, "Print out a resume");
  }

}
