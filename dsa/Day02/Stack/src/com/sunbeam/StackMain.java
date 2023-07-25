package com.sunbeam;

import java.util.Scanner;

public class StackMain {

	public static void main(String[] args) {
		int choice, data;
		Stack st = new Stack(4);
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("0. Exit");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 0:
				break;
			case 1:// push
				if(!st.isFull()) {
					System.out.println("Enter data to be added");
					data = sc.nextInt();
					st.push(data);
				}else {
					System.out.println("Stack is full");
				}
				break;
			case 2:// pop
				if(!st.isEmpty())
					System.out.println("Poped Data : " + st.pop());
				else
					System.out.println("Stack is empty");
				break;
			case 3:// peek
				if(!st.isEmpty())
					System.out.println("Peeked Data : " + st.peek());
				else
					System.out.println("Stack is empty");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}while(choice != 0);
		
		
		sc.close();


	}

}
