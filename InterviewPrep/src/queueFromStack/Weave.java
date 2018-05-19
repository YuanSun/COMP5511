package queueFromStack;

public class Weave {
  public static <T> StackQueue<T> weave(StackQueue<T> source1, StackQueue<T> source2) {
    final StackQueue<T> result = new StackQueue<>(); 
    while(!source1.isEmpty() || !source2.isEmpty()) {
      if(!source1.isEmpty()) {
        result.add(source1.remove());
      }
      
      if(!source2.isEmpty()) {
        result.add(source2.remove());
      }
    }
    
    return result;
  }
}
