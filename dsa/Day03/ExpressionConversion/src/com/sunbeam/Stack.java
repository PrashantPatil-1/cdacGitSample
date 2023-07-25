package com.sunbeam;

public class Stack {
	private char arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new char[SIZE];
		top = -1;
	}
	
	public void push(char data) {
		//a. reposition top(inc)
		top++;
		//b. add data at top index
		arr[top] = data;
	}
	
	public char pop() {
		char var = arr[top];
		//a. reposition top (dec)
		top--;
		return var;
	}
	
	public char peek() {
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










