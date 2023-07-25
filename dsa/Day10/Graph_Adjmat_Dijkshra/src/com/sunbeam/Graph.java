package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private static final int INF = 999;
	static class Table{
		private int dist[];
		private int parent[];
		private boolean spt[];
		public Table(int vCount) {
			dist = new int[vCount];
			parent = new int[vCount];
			spt = new boolean[vCount];
			for(int i = 0 ; i < vCount ; i++) {
				dist[i] = INF;
				parent[i] = -1;
				spt[i] = false;
			}
		}
		
		public int findMinDistVertex(int vCount) {
			int minDist = INF, minDistVertex = -1;;
			for(int i = 0 ; i < vCount ; i++) {
				if(!spt[i] && dist[i] < minDist) {
					minDist = dist[i];
					minDistVertex = i;
				}
			}
			return minDistVertex;
		}
		
		public void printDist(int start, int vCount) {
			System.out.println("Distances from " + start);
			for(int i = 0 ; i < vCount ; i++) {
				System.out.println(start + "->" + i + " = " + dist[i]);
			}
		}
	}
	
	private int edgeCount, vertexCount;
	private int adjmat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
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
	
	public void dijkstra(int start) {
		// create table to store dist, parents and spt
		Table tbl = new Table(vertexCount);
		// make key of start vertex 0
		tbl.dist[start] = 0;
		
		int vCount = 0;
		while(vCount < vertexCount) {
			// choose min key vertex
			int u = tbl.findMinDistVertex(vertexCount);
			// add min key vertex in spt
			tbl.spt[u] = true;
			// increment vCount
			vCount++;
			// update dist of adjacent vertices which are not added into spt
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] != INF && !tbl.spt[v] && tbl.dist[u] + adjmat[u][v] < tbl.dist[v]) {
					tbl.dist[v] = tbl.dist[u] + adjmat[u][v];
					tbl.parent[v] = u;
				}
			}
		}
		// print shortest distances of all others vertices from start vertex
		tbl.printDist(start, vertexCount);
	}

}






