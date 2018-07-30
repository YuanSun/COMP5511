package com.web.interview;

public class App {

  public static void main(String[] args) {
    int[] arr = new int[2];
    arr[0] = 2;
    arr[1] = 5;
    swap(arr);
    
    System.out.println(arr[0]);
    System.out.println(arr[1]);

  }

  private static void swap(int[] arr) {
    if (arr.length <= 1) {
      return;
    }
    
    for (int i = 0; i < arr.length / 2; i++) {
      arr[i] = arr[i] ^ arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = arr[arr.length - 1 - i]  ^ arr[i];
      arr[i] = arr[i] ^ arr[arr.length - 1 - i];
    }
  }

}
