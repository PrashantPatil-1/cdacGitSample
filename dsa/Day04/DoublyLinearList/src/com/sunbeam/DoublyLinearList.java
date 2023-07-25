package com.sunbeam;

public class DoublyLinearList {
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
	private Node tail;
	public DoublyLinearList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void displayForward() {
		// forward displat
		//1. create trav and start at first node
		Node trav = head;
		System.out.print("Forward List");
		while(trav != null) {
			//2. print data of current node
			System.out.print(" -> " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 untill trav != null
		System.out.println("");
	}
	
	public void displayReverse() {
		// forward display
		//1. create trav and start at last node
		Node trav = tail;
		System.out.print("Backward List");
		while(trav != null) {
			//2. print data of current node
			System.out.print(" -> " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}//4. repeat step 2 and 3 untill trav != null
		System.out.println("");
	}
	
	public void addFirst(int val) {
		//1. create node with data
		Node nn = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head and tail
			head = tail = nn;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add newnode into prev of first node
			head.prev = nn;
			//c. move head on newnode
			head = nn;
		}
	}
	
	public void addLast(int val) {
		//1. create node with data
		Node nn = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head and tail
			head = tail = nn;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			nn.prev = tail;
			//b. add newnode into next of last node
			tail.next = nn;
			//c. move tail on newnode
			tail = nn;
		}
	}
	
	public void addPos(int val, int pos) {
		//1. create node with data
		Node nn = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head and tail
			head = tail = nn;
		//3. if list is not empty
		else {
			//traverse till pos-1 node
			Node trav = head;
			for(int i = 1 ; i < pos -1 ; i++)
				trav = trav.next;
			//a. add pos node into next of newnode
			nn.next = trav.next;
			//b. add pos -1 node into prev of newnode
			nn.prev = trav;
			//c. add newnode into prev of pos node
			trav.next.prev = nn;
			//d. add newnode into next of pos-1 node
			trav.next = nn;
		}
	}
	
	public void delFirst() {
		if(isEmpty())
			return;
		//1. if list has single
		if(head.next == null)
			//a make head = tail = null
			head = tail = null;
		//2. if list has multiple nodes
		else {
			//a. move head on second node
			head = head.next;
			//b. add null into prev of second node
			head.prev = null;
		}
	}

	public void delLast() {
		if(isEmpty())
			return;
		//1. if list has single
		if(head.next == null)
			//a make head = tail = null
			head = tail = null;
		//2. if list has multiple nodes
		else {
			//a. move tail on second last node
			tail = tail.prev;
			//b. add null into next of second last node
			tail.next = null;
		}
	}
	
	public void delPos(int pos) {
		if(isEmpty())
			return;
		//1. if list has single node
		if(head.next == null)
			// make head = tail = null;
			head = tail = null;
		//2. if list has multiple nodes
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos-1 node into prev of pos+1 node
			trav.next.prev = trav.prev;
			//c. add pos+1 node into next of pos-1 node
			trav.prev.next = trav.next;
		}
	}
}








