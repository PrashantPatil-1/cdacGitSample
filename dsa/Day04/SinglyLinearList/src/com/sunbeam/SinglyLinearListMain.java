package com.sunbeam;

public class SinglyLinearListMain {

	public static void main(String[] args) {
		SinglyLinearList list = new SinglyLinearList();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		//10->20->30->40
		
		//list.addPosition(50, 6);
		//10->20->50->30->40
		list.deletePosition(5);
		list.displayList();
		
		list.deleteAll();
	}

}
