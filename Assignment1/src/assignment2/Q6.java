package assignment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q6 {
  private String FILENAME = "ds17s-asg2-data.txt";
  public ArrayList<String> data = new ArrayList<>();
  
  public Q6() throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(FILENAME)));
    try {
          String line;
          while ((line = br.readLine()) != null) {
              data.add(line.trim());
          }
        } finally {
            br.close();
        }
  }
  
  public static void selectionSort(String[] arr) {
    int n = arr.length;
    
    // One by one move boundary of unsorted subarray
    for (int i = 0; i < n-1; i++)
    {
        // Find the minimum element in unsorted array
        int min_idx = i;
        for (int j = i+1; j < n; j++)
            if (arr[j].compareToIgnoreCase(arr[min_idx]) < 0 )
                min_idx = j;

        // Swap the found minimum element with the first
        // element
        String temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
  }
  
  public static void quickSort(String[] arr) {
    quickSortExec(arr, 0, arr.length - 1);
  }
  
  private static void quickSortExec(String[] arr, int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSortExec(arr, left, index - 1);
    if (index < right)
      quickSortExec(arr, index, right);
  }
  
//divide the array into partitions
 private static int partition(String[] arr, int left, int right) {
   int i = left, j = right;
   String tmp;
   String pivot = arr[(left + right) / 2];

   while (i <= j) {
     while (arr[i].compareToIgnoreCase(pivot) < 0)
       i++;
     while (arr[j].compareToIgnoreCase(pivot) > 0)
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

}
