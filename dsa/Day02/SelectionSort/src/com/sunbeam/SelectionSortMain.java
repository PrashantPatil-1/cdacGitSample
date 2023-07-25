package com.sunbeam;

import java.util.Arrays;

public class SelectionSortMain {
	public static void SelectionSort(int arr[], int size) {
		for(int i = 0 ; i < size -1 ; i++) {	
			//1. select position of the array	-> i
			//2. Compare selected position element with all other elements of the array
			for(int j = i + 1 ; j < size ; j++) {
				//3.1. if selected element is greater than other element
				if(arr[i] > arr[j]) {
					//3.2. then swap selected element and other element
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}		
			}
		}//4. Repeat step 1 to 3, size -1 times
	}

	public static void main(String[] args) {
		int arr[] = {44, 11, 55, 22, 66, 33};
		
		System.out.println("Before : Array : " + Arrays.toString(arr));
		SelectionSort(arr, arr.length);
		System.out.println("After : Array : " + Arrays.toString(arr));
		
	}

}
