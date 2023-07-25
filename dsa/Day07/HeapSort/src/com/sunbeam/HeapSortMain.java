package com.sunbeam;

import java.util.Arrays;

public class HeapSortMain {

	public static void main(String[] args) {
		int arr[] = {6, 14, 3, 26, 8, 18, 21, 9, 5};
		Heap h = new Heap(arr.length + 1);
		
		System.out.println("Before sort : " + Arrays.toString(arr));
		h.heapSort(arr);
		System.out.println("After sort : " + Arrays.toString(arr));
	}

}
