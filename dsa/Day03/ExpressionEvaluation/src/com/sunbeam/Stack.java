package com.sunbeam;

public class Stack {
	private int arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = -1;
	}
	
	public void push(int data) {
		//a. reposition top(inc)
		top++;
		//b. add data at top index
		arr[top] = data;
	}
	
	public int pop() {
		int var = arr[top];
		//a. reposition top (dec)
		top--;
		return var;
	}
	
	public int peek() {
		// a. read data from top index
		return arr[top];
	}
	
	public boolean isFull() {
		return top == SIZE - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

}










