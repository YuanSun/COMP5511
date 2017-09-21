package assignment1;

public class Q6 {
  private int size;
  private int[] arrA;
  private int[] arrB;
  private int[] arrC;

  public Q6(int size) {
    arrA = RandomListUtil.generateRandomList(size, true);
    this.size = arrA.length;
    arrC = new int[this.size];
    arrB = new int[this.size];
    for (int i = 0; i < this.size; i++) {
      arrC[i] = 0;
    }
  }

  public void sortArrA() {
    // create arrC
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (arrA[i] > arrA[j]) {
          ++arrC[i];
        }
      }
    }

    // transfer arrA to arrB --> arrB = sorted arrA
    for (int i = 0; i < size; i++) {
      arrB[arrC[i]] = arrA[i];
    }

    display(arrA);
    display(arrB);
  }

  // print original array and sorted array
  void display(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.print("\n");
  }
}
