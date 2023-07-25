package com.sunbeam;

public class CircularQueue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	private int count;
	public CircularQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
		count = 0;
	}
	
	public void push(int data) {
		// inc rear
		rear = (rear + 1) % SIZE;
		// add data at rear index
		arr[rear] = data;
		// inc count
		count++;
	}
	
	public void pop() {
		// inc front
		front = (front + 1) % SIZE;
		// dec count
		count--;
	}
	
	public int peek() {
		// read data of front + 1
		return arr[(front + 1) % SIZE];
	}
	
	public boolean isFull() {
		return count == SIZE;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}

}








