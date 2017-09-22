package assignment1;

import java.util.HashMap;

public class Q5 {
  public int size;
  private int[] randomList;
  private int[] testList;
  public HashMap<String, Integer> result;
  private final static String FOUND = "FoundAtPosition";

  public Q5(int size, boolean normalRangeForRandomList, boolean normalSizeForTestList) {
    randomList = RandomListUtil.generateSortedRandomList(size, normalRangeForRandomList);
    testList = RandomListUtil.generateTestList(normalSizeForTestList);
    this.size = size;
    result = new HashMap<>();
  }

  // binary search with 1/3-2/3 strategy
  public boolean binarySearch(int target, boolean searchRandom) {
    if (searchRandom)
      return searchOneThird(randomList, 0, randomList.length - 1, target);
    else
      return searchOneThird(testList, 0, testList.length - 1, target);
  }

  private boolean searchOneThird(int[] arr, int left, int right, int target) {

    int pivotPos = left + (right - left) / 3;
    int pivot = arr[pivotPos];
    if (target == pivot) {
      result.put(FOUND, pivotPos);
      return true;
    }

    if ((right - left) <= 2) { // less or equal to 3 elements, do a whole search
      for (int i = left; i <= right; i++) {
        if (arr[i] == target) {
          result.put(FOUND, i);
          return true;
        }
      }
      return false;
    }

    if (target < pivot) {
      return searchOneThird(arr, left, pivotPos, target);
    } else {
      return searchOneThird(arr, pivotPos + 1, right, target);
    }
  }

  public void displayRandomList() {
    for (int i = 0; i < randomList.length; i++)
      System.out.println(randomList[i]);
  }

  public String displayTestList() {
    StringBuffer sb = new StringBuffer();
    sb.append("The test list is: \n");
    for (int i = 0; i < testList.length; i++)
      sb.append(this.testList[i] + " ");

    return sb.toString();
  }

}
