package spiralMatirx;

import java.util.ArrayList;

//--- Directions
//Write a function that accepts an integer N
//and returns a NxN spiral matrix.
//--- Examples
//matrix(2)
//  [[undefined, undefined],
//  [undefined, undefined]]
//matrix(3)
//  [[1, 2, 3],
//  [8, 9, 4],
//  [7, 6, 5]]
//matrix(4)
//  [[1,   2,  3, 4],
//  [12, 13, 14, 5],
//  [11, 16, 15, 6],
//  [10,  9,  8, 7]]

public class SpiralMatrix {
  static ArrayList<ArrayList<Integer>> matrix (Integer n) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i ++) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        temp.add(0);
      }
      result.add(temp);
    }
    
    int counter = 1;
    int startColumn = 0;
    int endColumn = n - 1;
    int startRow = 0;
    int endRow = n - 1;
    
    while (startColumn <= endColumn && startRow <= endRow) {
      // top row
      for (int i = startColumn; i <= endColumn; i++) {
        result.get(startRow).remove(i);
        result.get(startRow).add(i, counter);
        counter++;
      }
      startRow++;
      
      // right column 
      for (int i = startRow; i <= endRow; i++) {
        result.get(i).remove(endColumn);
        result.get(i).add(endColumn, counter);
        counter++;
      }
      endColumn --;
      
      // Bottom row
      for (int i = endColumn; i >= startColumn; i--) {
        result.get(endRow).remove(i);
        result.get(endRow).add(i, counter);
        counter++;
      }
      endRow--;
      
      // first Column
      for (int i = endRow; i >= startRow; i--) {
        result.get(i).remove(startColumn);
        result.get(i).add(startColumn, counter);
        counter++;
      }
      startColumn++;
    }
    
    return result;
  }
}
