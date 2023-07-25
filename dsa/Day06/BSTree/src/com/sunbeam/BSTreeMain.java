package com.sunbeam;

public class BSTreeMain {

	public static void main(String[] args) {
		BSTree bst = new BSTree();
		
		bst.addNode(8);
		bst.addNode(3);
		bst.addNode(10);
		bst.addNode(1);
		bst.addNode(6);
		bst.addNode(14);
		bst.addNode(4);
		bst.addNode(7);
		bst.addNode(13);
		
		bst.preOrder();
		bst.inOrder();
		bst.postOrder();
		
		BSTree.Node node = bst.searchNode(5);
		if(node != null)
			System.out.println("Key is found " + node.getData());
		else
			System.out.println("Key is not found");
		
		bst.deleteNode(4);
		bst.inOrder();

	}

}

