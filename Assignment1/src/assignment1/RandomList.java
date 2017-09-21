package assignment1;

import java.util.Random;

public class RandomList {
	public int size;
	public int[] randomList;
	private static final int MAXRANDOM = 100000;
	
	public RandomList(int size) {
		this.size = size;
		generateRandomList(size);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
		
		// regenerate randomList
		generateRandomList(size);
	}
	
	public int[] getList() {
		return this.randomList;
	}
	
	private void generateRandomList(int size) {
		randomList = new int[size];
		
		Random rand = new Random();
		
		for (int i = 0; i < size; i++) {
			randomList[i] = rand.nextInt(MAXRANDOM + 1);
		}
		
		this.sort(randomList);
	}

	// for test purpose, generate a list which is not random
	// from 1 - MAXRANDOM
	public int[] generateTestList() {
		int[] testList = new int[MAXRANDOM];
		for(int i = 0; i < MAXRANDOM; i++) {
			testList[i] = i + 1;
		}
		
		return testList;
	}
	
	// sort the list via quick sort
	private void sort(int[] randomList) {
		quickSort(randomList, 0, size - 1);
	}
	
	// divide the array into partitions
	private int partition(int arr[], int left, int right)
	{
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
	      };
	     
	      return i;
	}
	
	private void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
}
