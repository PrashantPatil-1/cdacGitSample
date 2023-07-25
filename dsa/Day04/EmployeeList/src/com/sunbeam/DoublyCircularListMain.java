package com.sunbeam;

public class DoublyCircularListMain {

	public static void main(String[] args) {

		DoublyCircularList list = new DoublyCircularList();
		
		list.addLast(new Employee(1, "abc", 12345));
		list.addLast(new Employee(2, "pqr", 23456));
		list.addLast(new Employee(3, "xyz", 19873));
		list.addLast(new Employee(4, "mno", 17864));
		list.displayForward();
	}

}
