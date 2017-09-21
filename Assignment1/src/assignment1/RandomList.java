package assignment1;

import java.util.Random;

public class RandomList {
  public int size;
  public int[] randomList;
  public int[] testList;
  private static final int MAXSIZE = 2000;

  public RandomList(int size) {
    this.size = size;
    generateRandomList(size);
    generateTestList();
  }

  public int getRandomListSize() {
    return this.size;
  }

  public int getTestListSize() {
    return MAXSIZE;
  }

  public void setRandomListSize(int size) {
    this.size = size;

    // regenerate randomList
    generateRandomList(size);
  }

  public int[] getRandomList() {
    return this.randomList;
  }

  public int[] getTestList() {
    return this.testList;
  }

  private void generateRandomList(int size) {
    this.randomList = new int[size];

    Random rand = new Random();

    for (int i = 0; i < size; i++) {
      this.randomList[i] = rand.nextInt(MAXSIZE + 1);
    }

    this.sort(this.randomList);
  }

  // for test purpose, generate a list which is not random
  // from 1 to MAXRANDOM
  private void generateTestList() {
    testList = new int[MAXSIZE];
    for (int i = 0; i < MAXSIZE; i++) {
      testList[i] = i + 1;
    }
  }

  // sort the list via quick sort
  private void sort(int[] randomList) {
    quickSort(randomList, 0, size - 1);
  }

  // divide the array into partitions
  private int partition(int arr[], int left, int right) {
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

  private void quickSort(int[] arr, int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
  }

  public String displayRandomList() {
    StringBuffer sb = new StringBuffer();
    sb.append("The random list is: \n");
    for (int i = 0; i < this.size; i++)
      sb.append(this.randomList[i] + " ");

    return sb.toString();
  }

  public String displayTestList() {
    StringBuffer sb = new StringBuffer();
    sb.append("The test list is: \n");
    for (int i = 0; i < MAXSIZE; i++)
      sb.append(this.testList[i] + " ");

    return sb.toString();
  }
}
