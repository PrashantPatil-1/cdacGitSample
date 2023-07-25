package com.sunbeam;

public class SinglyLinearListMain {

	public static void main(String[] args) {
		SinglyLinearList list = new SinglyLinearList();
		
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addLast(50);
		list.addLast(60);
		//40->30->20->10->50->60
		list.deleteFirst();
		list.deleteLast();
		
		list.displayList();
		
		list.deleteAll();
	}

}
