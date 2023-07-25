package com.sunbeam;

import java.util.Scanner;

// Adj Matrix for weighted Directed graph
public class AdjMatrixGraph {
	public static final int INF = 999;
	private int vertCount, edgeCount;
	private int adjmat[][];

	public AdjMatrixGraph(int vCount) {
		vertCount = vCount;
		adjmat = new int[vertCount][vertCount];
		for (int s = 0; s < adjmat.length; s++) {
			for (int d = 0; d < adjmat.length; d++)
				adjmat[s][d] = INF;
		}
	}

	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for(int i=0; i<edgeCount; i++) {
			System.out.println("Enter edge (src dest weight): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int weight = sc.nextInt();
			adjmat[src][dest] = weight;
			//adjmat[dest][src] = weight; // skip this line if graph is directed graph
		}
	}

	public void display() {
		for (int s = 0; s < vertCount; s++) {
			for (int d = 0; d < vertCount; d++) {
				System.out.print((adjmat[s][d] != INF ? adjmat[s][d] : "##") + "\t");
			}
			System.out.println();
		}
	}

	public void warshallFloyd() {
		int[][] dist = new int[vertCount][vertCount];
		for (int s = 0; s < vertCount; s++) {
			for (int d = 0; d < vertCount; d++)
				dist[s][d] = adjmat[s][d];
			dist[s][s] = 0;
		}

		for(int i = 0; i < vertCount; i++) {
			for (int s = 0; s < vertCount; s++) {
				for (int d = 0; d < vertCount; d++) {
					if(dist[s][i] != INF && dist[i][d] != INF && (dist[s][i] + dist[i][d]) < dist[s][d])
						dist[s][d] = dist[s][i] + dist[i][d];
				}
			}
		}

		for (int s = 0; s < vertCount; s++) {
			System.out.print("Dist from " + s + " : ");
			for (int d = 0; d < vertCount; d++) {
				System.out.print((dist[s][d] != INF ? dist[s][d] : "##") + "\t");
			}
			System.out.println();
		}
	}
}













