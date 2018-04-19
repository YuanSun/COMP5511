package arraychunking;

import java.util.ArrayList;

import org.junit.Test;

public class test {

  protected ArrayList<Integer> arr1 = new ArrayList<>();
  protected ArrayList<Integer> arr2 = new ArrayList<>();
  protected ArrayList<Integer> arr3 = new ArrayList<>();
  protected ArrayList<Integer> arr4 = new ArrayList<>();
  protected ArrayList<Integer> arr5 = new ArrayList<>();
  protected int size1 = 2;
  protected int size2 = 3;
  protected int size3 = 4;
  protected int size4 = 10;
  
  protected void setupTest() {
    for (int i = 1; i <= 4 ; i++) {
      arr1.add(i);
    }
    
    for (int i = 1; i <= 5 ; i++) {
      arr2.add(i);
    }
    
    for (int i = 1; i <= 8 ; i++) {
      arr3.add(i);
    }
    
    for (int i = 1; i <= 5 ; i++) {
      arr4.add(i);
    }
    
    for (int i = 1; i <= 5 ; i++) {
      arr5.add(i);
    }
  }
  
  @Test
  public void test() {
    
  }

}
