package com.sunbeam;

public class BSTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	
	public BSTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int val) {
		//1. create node with given data
		Node newnode = new Node(val);
		//2. if tree is empty
		if(isEmpty())
			//a. add newnode into root
			root = newnode;
		//3. if tree is not empty
		else {
			//3.1 create one trav pointer and start at root
			Node trav = root;
			while(true) {
				//3.2 if data is less than current node data
				if(val < trav.data) {
					//3.2.1 if current node's left is empty
					if(trav.left == null) {
						//add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if current node's left is not empty
					else
						//go to the left of current node
						trav = trav.left;
				}
				//3.3 if data is greater than current node data
				else {
					//3.3.1 if current node's right is empty
					if(trav.right == null){
						//add newnode into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if current node's right is not empty
					else	
						//go to the right of current node
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 and 3.3 untill node is added
		}
	}
	
	void preOrder(Node trav) {
		// stop if trav is null
		if(trav == null)
			return;
		// visit current node (print data)
		System.out.print(" " + trav.data);
		// go into left of current node
		preOrder(trav.left);
		// go into right of current node
		preOrder(trav.right);
	}
	
	void preOrder() {
		System.out.print("PreOrder : ");
		preOrder(root);
		System.out.println("");
	}

}






