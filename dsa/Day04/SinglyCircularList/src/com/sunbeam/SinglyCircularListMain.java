package com.sunbeam;

public class SinglyCircularListMain {

	public static void main(String[] args) {

		SinglyCircularList list = new SinglyCircularList();
		
		list.addFirst('M');
		list.addFirst('A');
		list.addFirst('E');
		list.addFirst('B');
		list.addFirst('N');
		list.addFirst('U');
		list.addFirst('S');
		list.addLast('K');
		//list.addPos('#', 8);
		
		//list.delFirst();
		//list.delLast();
		list.delPos(1);
		
		list.displayList();
		System.out.println("Node count : " + list.getCount());

	}

}
