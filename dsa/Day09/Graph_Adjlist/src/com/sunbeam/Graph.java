package com.sunbeam;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	private int vertexCount, edgeCount;
	private List<Integer> adjlist[];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjlist = new List[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			adjlist[i] = new ArrayList<Integer>();
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter Edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjlist[src].add(dest);
			adjlist[dest].add(src);
		}
	}
	
	public void display() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print(i + " -> ");
			for(Integer d : adjlist[i]) {
				System.out.print(d + " ");
			}
			System.out.println("");
		}
	}
	

}






