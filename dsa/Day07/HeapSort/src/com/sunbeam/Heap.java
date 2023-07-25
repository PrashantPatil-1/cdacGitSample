package com.sunbeam;

public class Heap {
	private int arr[];
	private int SIZE;
	public Heap(int size) {
		SIZE = 0;
		arr = new int[size];
	}
	
	public void addHeap(int ele) {
		// increment the size of heap
		SIZE++;
		// add element into first empty index
		arr[SIZE] = ele;
		// Find index of parent
		int pi = SIZE / 2;
		// Adjust the position of added element upto root
		while(pi >= 1) {
			// find index of left child
			int ci = pi * 2;
			// find index of maximum child
			if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			// if parent is greater than maximum child 
			// then break the loop (already max heap)
			if(arr[pi] > arr[ci])
				break;
			// if parent is not greater than maximum child 
			// then swap parent and maximum child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			// update the parent of maximum child
			pi = pi / 2;
		}
	}
	
	public int deleteMax() {
		// swap root element and last element of the heap
		int max = arr[1];
		arr[1] = arr[SIZE];
		arr[SIZE] = max;
		// decrement the heap size
		SIZE--;
		// find the index of left child
		int ci = 1 * 2;
		// adjust the position till last element of heap
		while(ci <= SIZE) {
			// find index of parent
			int pi = ci / 2;
			// find index of maximum child
			if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			// if parent is greater than maximum child
			// then break the loop(already max heap)
			if(arr[pi] > arr[ci])
				break;
			// if parent is not greater than maximum child
			// then swap parent and maximum child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci]  =temp;
			// update the child of parent
			ci = ci * 2;
		}
		return max;
	}
	
	public void makeHeap(int arr[]) {
		for(int i = 0 ; i < arr.length ; i++)
			addHeap(arr[i]);
	}
	
	public void deleteHeap(int arr[]) {
		for(int i = arr.length-1 ; i >= 0 ; i--)
			arr[i] = deleteMax();
	}
	
	public void heapSort(int arr[]) {
		//1. create heap
		makeHeap(arr);
		//2. delete heap
		deleteHeap(arr);
	}

}
