package com.sunbeam;

import java.util.Arrays;

public class insertionSortMain {
	
	public static void insertionSort(int arr[], int size) {
		for(int i = 1 ; i < size ; i++) {
			//1. take backup of one element from array
			int temp = arr[i];
			int j;
			//2. compare backuped element will all its left neighbours
			for(j = i - 1 ; j >= 0 && arr[j] > temp ; j--) {	
				//3. if left neighbour is greater than backuped element, then move left neighbour one position ahead
				arr[j + 1]  = arr[j];
			}
			//4.1 if array is finished then insert backuped element at first position
			//4.2 if backuped element is greater than immediate left neighbour, then insert backuped element at its position
			//4.3 if left neighbour is less than backuped element then insert backuped element next to left neighbour
			arr[j + 1] = temp;
		}//5. repeat step 1 to 4, size -1 times
	}

	public static void main(String[] args) {
		int arr[] = {55, 44, 22, 66, 11, 33};
		
		System.out.println("Before Array : " + Arrays.toString(arr));
		insertionSort(arr, arr.length);
		System.out.println("After Array : " + Arrays.toString(arr));
	}

}


