package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Edge{
		private int src;
		private int dest;
		private int wt;
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			wt = w;
		}
	}
	private static final int INF = 999;
	private int edgeCount, vertexCount;
	private int adjmat[][];
	private List<Edge> edgeList;
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		edgeList = new ArrayList<>();
		for(int i = 0 ; i < vertexCount ; i++)
			for(int j = 0 ; j < vertexCount ; j++)
				adjmat[i][j] = INF;
	}
	public void accept(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			edgeList.add(new Edge(src, dest, wt));
		}	
	}
	
	public void display() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++){
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print(adjmat[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void bellmanFord(int start) {
		// create array to store distances
		int dist[] = new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			dist[i] = INF;
		// make start vertex dist 0
		dist[start] = 0;
		// relax all edges v - 1 times
		for(int i = 0 ; i < vertexCount - 1 ; i++) {
			for(Edge e : edgeList) {
				int u = e.src, v = e.dest, w = e.wt;
				if(dist[u] != INF && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}
		// relax one more time to detect -ve edge cycle 
		for(Edge e : edgeList) {
			int u = e.src, v = e.dest, w = e.wt;
			if(dist[u] != INF && dist[u] + w < dist[v]) {
				return;
			}
		}
		
		// print shortest distances
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(start + "->" + i + " = " + dist[i]);
	}

}






