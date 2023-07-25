package com.sunbeam;

public class linearQueue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	public linearQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = -1;
		rear = -1;
	}
	
	public void push(int data) {
		//a. reposition rear (inc)
		rear++;
		//b. add data at rear index
		arr[rear] = data;
	}
	
	public void pop() {
		//a. reposition front (inc)
		front++;
	}
	
	public int peek() {
		//a. read data of front + 1 index
		return arr[front + 1];
	}
	
	 public boolean isFull() {
		 return rear == SIZE - 1;
	 }
	 
	 public boolean isEmpty() {
		 return front == rear;
	 }
}












