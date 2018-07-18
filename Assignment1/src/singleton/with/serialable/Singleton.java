package singleton.with.serialable;

import java.io.Serializable;

public class Singleton implements Serializable {
  public static final Singleton INSTANCE = new Singleton();
  private int value;
  private Singleton() {
    
  }
  
  public void setValue(int num) {
    value = num;
  }
  
  public int getValue() {
    return value;
  }
  
  protected Object readResolve() {
    return INSTANCE;
  }
}
