package arraychunking;

import java.util.ArrayList;
//--- Directions
//Given an array and chunk size, divide the array into many subarrays
//where each subarray is of length size
//--- Examples
//chunk([1, 2, 3, 4], 2) --> [[ 1, 2], [3, 4]]
//chunk([1, 2, 3, 4, 5], 2) --> [[ 1, 2], [3, 4], [5]]
//chunk([1, 2, 3, 4, 5, 6, 7, 8], 3) --> [[ 1, 2, 3], [4, 5, 6], [7, 8]]
//chunk([1, 2, 3, 4, 5], 4) --> [[ 1, 2, 3, 4], [5]]
//chunk([1, 2, 3, 4, 5], 10) --> [[ 1, 2, 3, 4, 5]]
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
