package com.sunbeam;

import java.util.Scanner;

public class GraphMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		g.accept(sc);
		//g.DFSTraversal(0);
		//g.BFSTraversal(0);
		//g.singleSorcePathLength(0);
		g.DFSSpanningTree(0);
		g.BFSSpanningTree(0);
		sc.close();
	}
}

/*
6
7
0 1
0 2
0 3
1 4
1 2
3 4
3 5
*/







