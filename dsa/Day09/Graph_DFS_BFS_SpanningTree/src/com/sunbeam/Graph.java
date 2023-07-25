package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	private int edgeCount, vertexCount;
	private boolean adjmat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new boolean[vertexCount][vertexCount];
	}
	public void accept(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjmat[src][dest] = true;
			adjmat[dest][src] = true;
		}	
	}
	
	public void display() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++){
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print(adjmat[i][j] ? 1 + " ": 0 + " ");
			}
			System.out.println("");
		}
	}
	
	public void DFSSpanningTree(int start) {
		// create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		// create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//1. Choose a vertex as start vertex. - start
		//2. Push start vertex on stack & mark it. 
		st.push(start);
		marked[start] = true;
		System.out.println("DFS Spanning Tree : ");
		while(!st.isEmpty()) {
			//3. Pop vertex from stack.
			int u = st.pop();
			//5. Put all non-visited neighbours of the vertex on the stack and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					st.push(v);
					marked[v] = true;
					System.out.println(u + "->" + v);
				}
			}
		}//6. Repeat 3-5 until stack is empty.
	}
	
	public void BFSSpanningTree(int start) {
		// create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		// create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//1. Choose a vertex as start vertex. - start
		//2. Push start vertex on queue & mark it. 
		q.offer(start);
		marked[start] = true;
		System.out.println("BFS Spanning Tree : ");
		while(!q.isEmpty()) {
			//3. Pop vertex from queue.
			int u = q.poll();
			//5. Put all non-visited neighbours of the vertex on the queue and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					q.offer(v);
					marked[v] = true;
					System.out.println(u + "->" + v);
				}
			}
		}//6. Repeat 3-5 until stack is empty.
	}

}






