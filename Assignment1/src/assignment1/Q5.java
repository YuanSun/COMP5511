package assignment1;

import java.util.HashMap;

public class Q5 {
  public RandomList theList;
  public int size;
  private int[] randomList;
  private int[] testList;
  public HashMap<String, Integer> result;

  public Q5(int size) {
    theList = new RandomList(size);
    randomList = theList.getRandomList();
    testList = theList.getTestList();
  }

  // binary search with 1/3-2/3 strategy
  public boolean binarySearch(int target, boolean searchRandom) {
    if (searchRandom)
      return searchOneThird(randomList, 0, theList.getRandomListSize() - 1, target);
    else
      return searchOneThird(testList, 0, theList.getTestListSize() - 1, target);
  }

  private boolean searchOneThird(int[] arr, int left, int right, int target) {
    int pivotPos = left + (right - left) / 3;
    int pivot = arr[pivotPos];
    if (target == pivot)
      return true;

    if ((right - left) <= 2) { // less or equal to 3 elements, do a whole search
      for (int i = left; i <= right; i++) {
        if (arr[i] == target)
          return true;
      }
      return false;
    }

    if (target < pivot) {
      return searchOneThird(arr, left, pivotPos, target);
    } else {
      return searchOneThird(arr, pivotPos + 1, right, target);
    }
  }

}
