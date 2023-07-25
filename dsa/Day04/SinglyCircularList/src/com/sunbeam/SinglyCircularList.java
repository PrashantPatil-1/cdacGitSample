package com.sunbeam;

public class SinglyCircularList {
	static class Node{
		private char data;
		private Node next;
		public Node(char val) {
			data = val;
			next = null;
		}
	}
	
	private Node head;
	private int count;
	public SinglyCircularList() {
		head = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getCount() {
		return count;
	}
	
	public void displayList() {
		//1. create one trav referance and start it from head
		Node trav = head;
		System.out.print("List");
		do {
			//2. print data of current node(trav)
			System.out.print(" -> " + trav.data);
			//3. go on next node(trav.next)
			trav = trav.next;
		}while(trav != head);//4. repeat step 2 and 3 untill trav != head
		System.out.println("");
	}
	
	public void addFirst(char val) {
		//1. create node with given data
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			head.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			//c. add newnode into next of last node
			trav.next = newnode;
			//d. move head on newnode
			head = newnode;
		}
		// increment count
		count++;
	}
	
	public void addLast(char val) {
		//1. create node with given data
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			head.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			//c. add newnode into next of last node
			trav.next = newnode;
		}
		// increment count
		count++;
	}
	
	public void addPos(char val, int pos) {
		if(pos < 1 || pos > count + 1)
			return;
		//1. create node with given data
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			head.next = head;
		}
		//3. if list is not empty
		else if (pos == 1) {
			addFirst(val);
			return;
		}
		else {
			//a. traverse till pos -1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos + 1 node into next of newnode
			newnode.next = trav.next;
			//c. add newnode into next of pos -1 node
			trav.next = newnode;
		}
		count++;
	}
	
	public void delFirst() {
		if(isEmpty())
			return;
		//1. if list has single node
		if(head.next == head)
			//a. make head equal to null
			head = null;
		//2. if list has multiple nodes
		else {
			//a. traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			//b. add second node into next of last node
			trav.next = head.next;
			//c. move head on second node
			head = head.next;
		}
		count--;
	}
	
	public void delLast() {
		if(isEmpty())
			return;
		//1. if list has single node
		if(head.next == head)
			// make head equal to null
			head = null;
		//2. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != head)
				trav = trav.next;
			//b. add head into next of second last node
			trav.next = head;
		}
		count--;
	}
	
	public void delPos(int pos) {
		if(pos < 1 || pos > count)
			return;
		if(isEmpty())
			return;
		//1. if list has single node
		if(head.next == head)
			// make head equal to null
			head = null;
		//2. if list has multiple nodes
		else if(pos == 1) {
			delFirst();
			return;
		}
		else {
			//a. traverse till pos-1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos+1 node into next of pos-1 node
			trav.next = trav.next.next;
		}
		count--;
	}

}








