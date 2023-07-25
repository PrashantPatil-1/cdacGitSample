package com.sunbeam;

import java.util.Scanner;

public class linearQueueMain {

	public static void main(String[] args) {
		int choice, data;
		linearQueue q = new linearQueue(4);
		
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
				if(!q.isFull()) {
					System.out.println("Enter data to be added");
					data = sc.nextInt();
					q.push(data);
				}else {
					System.out.println("Queue is full");
				}
				break;
			case 2:// pop
				if(!q.isEmpty())
					q.pop();
				else
					System.out.println("Queue is empty");
				break;
			case 3:// peek
				if(!q.isEmpty())
					System.out.println("Peeked Data : " + q.peek());
				else
					System.out.println("Queue is empty");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}while(choice != 0);
		
		
		sc.close();
	}

}
