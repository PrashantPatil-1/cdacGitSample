package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private static final int INF = 999;
	static class Table{
		private int keys[];
		private int parent[];
		private boolean mst[];
		public Table(int vCount) {
			keys = new int[vCount];
			parent = new int[vCount];
			mst = new boolean[vCount];
			for(int i = 0 ; i < vCount ; i++) {
				keys[i] = INF;
				parent[i] = -1;
				mst[i] = false;
			}
		}
		
		public int findMinKeyVertex(int vCount) {
			int minKey = INF, minKeyVertex = -1;;
			for(int i = 0 ; i < vCount ; i++) {
				if(!mst[i] && keys[i] < minKey) {
					minKey = keys[i];
					minKeyVertex = i;
				}
			}
			return minKeyVertex;
		}
		
		public int printMST(int vCount) {
			int wt = 0;
			for(int i = 0 ; i < vCount ; i++) {
				wt += keys[i];
				System.out.println(parent[i] + "->" + i);
			}
			return wt;
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
			adjmat[dest][src] = wt;
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
	
	public void primsMST(int start) {
		// create table to store keys, parents and mst
		Table tbl = new Table(vertexCount);
		// make key of start vertex 0
		tbl.keys[start] = 0;
		
		int vCount = 0;
		while(vCount < vertexCount) {
			// choose min key vertex
			int u = tbl.findMinKeyVertex(vertexCount);
			// add min key vertex in mst
			tbl.mst[u] = true;
			// increment vCount
			vCount++;
			// update keys of adjacent vertices which are not added into mst
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] != INF && !tbl.mst[v] && adjmat[u][v] < tbl.keys[v]) {
					tbl.keys[v] = adjmat[u][v];
					tbl.parent[v] = u;
				}
			}
		}
		// print mst and find the weight
		int weight = tbl.printMST(vertexCount);
		System.out.println("Weight of MST : " + weight);
	}

}






