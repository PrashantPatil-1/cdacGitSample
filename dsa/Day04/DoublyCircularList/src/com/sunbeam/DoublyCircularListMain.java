package com.sunbeam;

public class DoublyCircularListMain {

	public static void main(String[] args) {

		DoublyCircularList list = new DoublyCircularList();
		
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.addLast(50);
		list.addLast(60);
		
		list.delFirst();
		list.delLast();
		
		list.displayForward();
		list.displaybackward();

	}

}
