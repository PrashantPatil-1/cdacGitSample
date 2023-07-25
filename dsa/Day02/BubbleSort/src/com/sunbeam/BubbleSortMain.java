package com.sunbeam;

import java.util.Arrays;

public class BubbleSortMain {
	public static void bubbleSort(int arr[], int size) {
		int passes = 0, comps = 0;
		for(int i = 1 ; i < size ; i++) {
			passes++;
			for(int j = 0 ; j < size - 1 ; j++) {
				//1. compare two consecutive elements
				comps++;
				if(arr[j] > arr[j + 1])	{//2.1. if left element is greater than right element
					//2.2. swap left and right elements
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}//3. repeat step 1 and 2 till array is not finished
		}//4. repeat step 1 to 3, size -1 times
		System.out.println("No of passes : " + passes);
		System.out.println("No of comps : " + comps);
	}
	public static void improvedBubbleSort(int arr[], int size) {
		int passes = 0, comps = 0;
		for(int i = 1 ; i < size ; i++) {
			passes++;
			for(int j = 0 ; j < size - i ; j++) {
				//1. compare two consecutive elements
				comps++;
				if(arr[j] > arr[j + 1])	{//2.1. if left element is greater than right element
					//2.2. swap left and right elements
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}//3. repeat step 1 and 2 till array is not finished
		}//4. repeat step 1 to 3, size -1 times
		System.out.println("No of passes : " + passes);
		System.out.println("No of comps : " + comps);
	}
	
	public static void furtherImprovedBubbleSort(int arr[], int size) {
		int passes = 0, comps = 0;
		int flag;
		for(int i = 1 ; i < size ; i++) {
			passes++;
			flag = 0;
			for(int j = 0 ; j < size - i ; j++) {
				//1. compare two consecutive elements
				comps++;
				if(arr[j] > arr[j + 1])	{//2.1. if left element is greater than right element
					//2.2. swap left and right elements
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = 1;
				}
			}//3. repeat step 1 and 2 till array is not finished
			if(flag == 0)
				break;
		}//4. repeat step 1 to 3, size -1 times
		System.out.println("No of passes : " + passes);
		System.out.println("No of comps : " + comps);
	}
	public static void main(String[] args) {
		//int arr[] = {33, 22, 66, 55, 44, 11};
		int arr[] = {11, 22, 33, 44, 55, 66};
		System.out.println("Before Array : " + Arrays.toString(arr));
		//bubbleSort(arr, arr.length);
		//improvedBubbleSort(arr, arr.length);
		furtherImprovedBubbleSort(arr, arr.length);
		System.out.println("After Array : " + Arrays.toString(arr));
	}

}




