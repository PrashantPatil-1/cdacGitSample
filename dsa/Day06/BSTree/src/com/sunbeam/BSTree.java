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
		public int getData() {
			return data;
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
	
	public void preOrder(Node trav) {
		// stop when trav is null
		if(trav == null)
			return;
		// print the current visit
		System.out.print(" " + trav.data);
		// go to the left of current node
		preOrder(trav.left);
		// go to the right of current node
		preOrder(trav.right);
	}
	
	public void preOrder() {
		System.out.print("Preorder : ");
		preOrder(root);
		System.out.println("");
	}
	
	public void inOrder(Node trav) {
		// stop when trav is null
		if(trav == null)
			return;
		// go to the left of current node
		inOrder(trav.left);
		// print the current visit
		System.out.print(" " + trav.data);
		// go to the right of current node
		inOrder(trav.right);
	}
	
	public void inOrder() {
		System.out.print("Inorder : ");
		inOrder(root);
		System.out.println("");
	}
	
	public void postOrder(Node trav) {
		// stop when trav is null
		if(trav == null)
			return;
		// go to the left of current node
		postOrder(trav.left);
		// go to the right of current node
		postOrder(trav.right);
		// print the current visit
		System.out.print(" " + trav.data);
	}
	
	public void postOrder() {
		System.out.print("Postorder : ");
		postOrder(root);
		System.out.println("");
	}
	
	public Node searchNode(int key) {
		//1. start from root
		Node trav = root;
		while(trav != null) {
			//2. if key is equal to current data
			if(key == trav.data)
				//return current node
				return trav;
			//3. if key is less than current data
			if(key < trav.data)
				// search key into left of current node
				trav = trav.left;
			//4. if key is greater than current data
			else
				// search key into right of current node
				trav = trav.right;
		}//5. repeat step 2 to 4 till leaf nodes 
		return null;
	}
	
	public Node[] searchNodeWithParent(int key) {
		//1. start from root
		Node trav = root;
		Node parent = null;
		while(trav != null) {
			//2. if key is equal to current data
			if(key == trav.data)
				break;
			parent = trav;
			//3. if key is less than current data
			if(key < trav.data)
				// search key into left of current node
				trav = trav.left;
			//4. if key is greater than current data
			else
				// search key into right of current node
				trav = trav.right;
		}//5. repeat step 2 to 4 till leaf nodes 
		if(trav == null)
			parent = null;
		return new Node[] {trav, parent};
	}
	
	public void deleteNode(int val) {
		//1. search node to be deleted
		Node arr[] = searchNodeWithParent(val);
		Node temp = arr[0]; Node parent = arr[1];
		// if node is not found then simply return
		if(temp == null)
			return;
		//2. check if node has two childs
		if(temp.left != null && temp.right != null){
			Node trav = temp.left;
			parent = temp;
			while(trav.right != null) {
				parent = trav;
				trav = trav.right;
			}
			temp.data = trav.data;
			temp = trav;
		}
		//3. check if node has single child(right)
		if(temp.left == null){
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp.right;
			else
				parent.right = temp.right;
		}
		//4. if node has single child(left)
		else if(temp.right == null){
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else
				parent.right = temp.left;
		}
	}
	
}






