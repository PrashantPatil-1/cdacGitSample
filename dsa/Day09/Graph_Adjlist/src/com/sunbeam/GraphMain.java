package com.sunbeam;

import java.util.Scanner;

public class GraphMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		g.display();
		
		sc.close();

	}

}
