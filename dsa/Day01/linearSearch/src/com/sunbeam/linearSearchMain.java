package com.sunbeam;

import java.util.Scanner;

public class linearSearchMain {
	public static int linearSearch(int arr[], int size, int key) {
		//2. traverse the array from first to last element
		for(int i = 0 ; i < size ; i++) {
			//3. compare key with element of array
			if(key == arr[i])
				return i;	//4. key is found at ith index
		}
		//5. if key is not found then return -1
		return -1;		
	}

	public static void main(String[] args) {
		int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 14};
		
		//1. take key from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key to be search : ");
		int key = sc.nextInt();
		
		int index = linearSearch(arr, arr.length, key);
		if(index == -1)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found at index" + index);
		sc.close();
	}

}
