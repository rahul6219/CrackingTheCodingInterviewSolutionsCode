package crackingcoding_chapter4;
import java.util.*;

public class Ch4Q3LinkedListDepth {

	// List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
	// at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
	Node root;
	LinkedList<Integer> adjList[];
	int sizeofTree;
	
	public Ch4Q3LinkedListDepth()
	{
		sizeofTree=sizeOfBinaryTree(root);
		
		adjList= new LinkedList[sizeofTree];
		
		for(int i=0; i<adjList.length; i++)
		{
			adjList[i]= new LinkedList<Integer>();
		}
	}

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public int sizeOfBinaryTree(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		
		return 1+  sizeOfBinaryTree(root.left) +  sizeOfBinaryTree(root.right);
		
	}

	public void add(int data) {
		root = addRecursive(root, data);
		
	}

	public Node addRecursive(Node current, int data) {
		if (current == null) {
			Node newNode = new Node(data);
			return newNode;
		}

		if (data < current.data) {
			current.left = addRecursive(current.left, data);

		} else if (data > current.data) {
			current.right = addRecursive(current.right, data);

		} else {
			return current;
		}

		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

	}

}
