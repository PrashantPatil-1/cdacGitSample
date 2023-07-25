package com.sunbeam;

import java.util.Arrays;

public class MergeSortMain {
	public static void mergeSort(int arr[], int left, int right) {
		// stop when will get single element partition
		if(left == right)
			return;
		//1. Divide collection (array) into two parts
		int mid = (left + right)/2;
		//2. Sort each part individually
		//2.1 call same merge sort function on left partition
		mergeSort(arr, left, mid);
		//2.2 call same merge sort function on right partition
		mergeSort(arr, mid + 1, right);
		//3. merge two sorted partitions in such a way that merged array is sorted
		//3.1 find size of temp array
		int size = right - left + 1;
		int temp[] = new int[size];
		int i = left, j = mid + 1, k = 0;
		//3.2 start merging two partitions
		while(i <= mid && j <= right) {
			/*
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				temp[k] = arr[j];
				j++;
				k++;
			}*/
			temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		//3.3 if partition 2 is finished then add remaining element of partition 1 into temp array
		while(i <= mid) {
			/*temp[k] = arr[i];
			i++;
			k++;*/
			temp[k++] = arr[i++];
		}
		//3.3 if partition 1 is finished then add remaining element of partition 2 into temp array
		while(j <= right) {
			/*temp[k] = arr[j];
			j++;
			k++;*/
			temp[k++] = arr[j++];
		}
		//4. overwrite temp array into original array
		for(i = 0 ; i < size ; i++)
			arr[i + left] = temp[i];
	}

	public static void main(String[] args) {
		int arr[] = {6, 3, 9, 7, 1, 8, 2, 4, 5};
		
		System.out.println("Before Array : " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("After Array : " + Arrays.toString(arr));
	}

}
