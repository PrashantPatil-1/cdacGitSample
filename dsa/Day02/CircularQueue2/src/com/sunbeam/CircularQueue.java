package com.sunbeam;

public class CircularQueue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	public CircularQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void push(int data) {
		// inc rear
		rear = (rear + 1) % SIZE;
		// add data at rear index
		arr[rear] = data;
	}
	
	public void pop() {
		// inc front
		front = (front + 1) % SIZE;
		if(front == rear)
			front = rear = -1;
	}
	
	public int peek() {
		// read data of front + 1
		return arr[(front + 1) % SIZE];
	}
	
	public boolean isFull() {
		return (rear == SIZE -1 && front == -1) || (front == rear && rear != -1);
	}
	
	public boolean isEmpty() {
		return front == rear && rear == -1;
	}

}








