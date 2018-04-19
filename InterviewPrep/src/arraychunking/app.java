package arraychunking;

import java.util.ArrayList;

public class app {

  public static void main(String[] args) {
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    ArrayList<Integer> arr3 = new ArrayList<>();
    ArrayList<Integer> arr4 = new ArrayList<>();
    ArrayList<Integer> arr5 = new ArrayList<>();
    int size1 = 2;
    int size2 = 3;
    int size3 = 4;
    int size4 = 10;
    
    setupTest(arr1, arr2, arr3, arr4, arr5);
    System.out.println(ChunkArray.chunk(arr1, size1));
    System.out.println(ChunkArray.chunk(arr2, size1));
    System.out.println(ChunkArray.chunk(arr3, size2));
    System.out.println(ChunkArray.chunk(arr4, size3));
    System.out.println(ChunkArray.chunk(arr5, size4));
    

  }
  
  protected static void setupTest(ArrayList<Integer> arr1, ArrayList<Integer> arr2, 
      ArrayList<Integer> arr3, ArrayList<Integer> arr4, ArrayList<Integer> arr5) {
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

}
