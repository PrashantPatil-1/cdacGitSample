package com.sunbeam;

import java.util.Arrays;

public class QuickSortMain {
	public static void quickSort(int arr[], int left, int right) {
		//0. stop if single element partition or invalid partition
		if(left >= right)
			return;
		//1. select pivot (axis/referance) element from array
		// arr[left] - pivot
		//2. arrange all smaller elements than pivot to the left side of pivot
		//3. arrange all greater elements than pivot to the right side of pivot
		int i = left, j = right;
		while(i < j) {
			//3.1 find element greater than pivot
			for( ; i <= right && arr[i] <= arr[left] ; i++);
			//3.2 find element less and equal than pivot
			for( ; arr[j] > arr[left] ; j--);
			//3.3 if i and j are not crossed the swap ith and jth element
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}// repeat step 3.1 to 3.3 till i and j are not crossed
		//4. swap jth element with pivot
		int temp = arr[j];
		arr[j] = arr[left];
		arr[left] = temp;
		//5. sort individual partitions(left and right of pivot) by applying same method
		quickSort(arr, left, j - 1);
		quickSort(arr, j + 1, right);
	}

	public static void main(String[] args) {
		int arr[] = {66, 33, 99, 11, 77, 22, 55, 66, 88};
		
		System.out.println("Array before : " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println("Array after : " + Arrays.toString(arr));
	}

}
