package com.sunbeam;

public class SinglyLinearList {
	static class Node{
		private int data;
		private Node next;
		public Node(int val) {
			data = val;
			next = null;
		}
	}
	
	private Node head;
	public SinglyLinearList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int val) {
		//0. create node with given data
		Node newnode = new Node(val);
		//1. if list is empty
		if(isEmpty())
			//a. add newnode into head itself
			head = newnode;
		//2. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into head
			head = newnode;
		}
	}
	
	public void addLast(int val) {
		//1. create node with given data
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head
			head = newnode;
		//3. if list is not empty
		else {
			//a. traverse till last node (trav.next != null)
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			//b. add newnode into next of last node
			trav.next = newnode;
		}
	}
	
	public void displayList() {
		//1. create one referance and start from first node
		Node trav = head;
		System.out.println("List : ");
		while(trav != null) {
			//2. print/visit current node
			System.out.println(trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 untill trav != null
	}
	
	public void deleteFirst() {
		//1. if list is not empty
		if(!isEmpty())
			//a. move head on second node
			head = head.next;
	}
	
	public void deleteLast() {
		if(isEmpty())
			return;
		//1. if list has single node
		if(head.next == null)
			//a. make head equal to null
			head = null;
		//2. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != null)
				trav = trav.next;
			//b. make next of second last node equal to null
			trav.next = null;
		}
	}
	
	public void deleteAll() {
		head = null;
	}

}






