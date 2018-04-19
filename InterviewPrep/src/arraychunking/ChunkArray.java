package arraychunking;

import java.util.ArrayList;

public class ChunkArray {
  static ArrayList<ArrayList<Integer>> chunk(ArrayList<Integer> arr, int size) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    while(!arr.isEmpty()) {
      ArrayList<Integer> helpResolver = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        if(!arr.isEmpty()) {
          helpResolver.add(arr.remove(0));
        } else {
          break;
        }
        
      }
      result.add(helpResolver);
    }
    
    return result;
  }
  
 
}
