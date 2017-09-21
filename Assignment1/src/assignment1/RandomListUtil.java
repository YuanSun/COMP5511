package assignment1;

import java.util.Random;

public class RandomListUtil {
  private static final int MAXRANGE = Integer.MAX_VALUE;
  private static final int MAXSIZE = 200000;
  private static final int NORMALRANGE = 2000;
  private static final int NORMALSIZE = 2000;



  public static int[] generateRandomList(int size, boolean normalRange) {
    int[] arr = new int[size];

    Random rand = new Random();
    if (!normalRange) {
      for (int i = 0; i < size; i++) {
        arr[i] = rand.nextInt(MAXRANGE);
      }
    } else {
      for (int i = 0; i < size; i++)
        arr[i] = rand.nextInt(NORMALRANGE);
    }
    sort(arr);
    return arr;
  }

  // for test purpose, generate a list which is not random
  // from 1 to MAXRANDOM
  public static int[] generateTestList(boolean normalSize) {
    if (!normalSize) {
      int[] arr = new int[MAXSIZE];
      for (int i = 0; i < MAXSIZE; i++) {
        arr[i] = i + 1;
      }
      return arr;
    } else {
      int[] arr = new int[NORMALSIZE];
      for (int i = 0; i < NORMALSIZE; i++) {
        arr[i] = i + 1;
      }

      return arr;
    }
  }

  // sort the list via quick sort
  private static void sort(int[] randomList) {
    quickSort(randomList, 0, randomList.length - 1);
  }

  // divide the array into partitions
  private static int partition(int[] arr, int left, int right) {
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];

    while (i <= j) {
      while (arr[i] < pivot)
        i++;
      while (arr[j] > pivot)
        j--;
      if (i <= j) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    } ;

    return i;
  }

  private static void quickSort(int[] arr, int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
  }
}
