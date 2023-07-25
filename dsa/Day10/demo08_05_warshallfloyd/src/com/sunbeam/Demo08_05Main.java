
package com.sunbeam;

import java.util.Scanner;

public class Demo08_05Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vCount = sc.nextInt();
		AdjMatrixGraph g = new AdjMatrixGraph(vCount);
		g.accept(sc);
		g.display();
		g.warshallFloyd();
	}
}

/*
5
7
3 4 3
2 4 3
2 3 4
2 1 -2
1 3 -1
0 2 5
0 1 6
*/