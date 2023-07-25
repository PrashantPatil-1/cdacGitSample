package com.sunbeam;

public class DoublyCircularList {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}
	}
	
	private Node head;
	
	public DoublyCircularList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void displayForward() {
		// Forward display
		//1. create trav and start at first node
		Node trav = head;
		System.out.print("Forward : ");
		do {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);//4. repeat step 2 and 3 till last node 
		System.out.println("");
	}
	
	public void displaybackward() {
		// Forward display
		//1. create trav and start at last node
		Node trav = head.prev;
		System.out.print("Backward : ");
		do {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}while(trav != head.prev);//4. repeat step 2 and 3 till last node 
		System.out.println("");
	}
	
	public void addFirst(int val) {
		//1. create node
		Node nn = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = nn;
			//b. make it circular
			head.next = head;
			head.prev = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add last node into prev of newnode
			nn.prev = head.prev;
			//c. add newnode into next of last node
			head.prev.next = nn;
			//d. add newnode into prev of first node
			head.prev = nn;
			//e. add nenwode into head	
			head = nn;
		}
	}
	
	public void addLast(int val) {
		//1. create node
		Node nn = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = nn;
			//b. make it circular
			head.next = head;
			head.prev = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add last node into prev of newnode
			nn.prev = head.prev;
			//c. add newnode into next of last node
			head.prev.next = nn;
			//d. add newnode into prev of first node
			head.prev = nn;
		}
	}
	
	public void delFirst() {
		if(isEmpty())
			return;
		//1. if list has single node
		if(head.next == head)
			//make head = null
			head = null;
		//2. if list has multiple nodes
		else {
			//a. add second node into next of last node
			head.prev.next = head.next;
			//b. add last node into prev of second node
			head.next.prev = head.prev;
			//c. move head on second node
			head = head.next;
		}
	}
	
	public void delLast() {
		if(isEmpty())
			return ;
		//1. if list has single node
		if(head.next == head)
			//make head = null
			head = null;
		//2. if list has multiple nodes
		else {
			//a. add first node into next of second last node
			head.prev.prev.next = head;
			//b. add second last node into prev of first node
			head.prev = head.prev.prev;
		}
	}
	
}







