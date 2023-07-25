package com.sunbeam;

public class DoublyLinearListMain {

	public static void main(String[] args) {
		DoublyLinearList list = new DoublyLinearList();
		
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.addLast(50);
		list.addLast(60);
		//list.addPos(88, 3);
		
		//list.delFirst();
		//list.delLast();
		list.delPos(3);
		
		list.displayForward();
		list.displayReverse();
	}

}
