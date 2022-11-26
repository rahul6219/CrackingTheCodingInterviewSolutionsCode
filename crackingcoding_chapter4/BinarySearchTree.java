package crackingcoding_chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree {

	Node root;
	ArrayList<Node> adjList;

	public BinarySearchTree() {
		root = null;
		adjList = new ArrayList<>();

	}

	public void add(int data) {
		root = addRecursive(root, data);
	}

	public Node addRecursive(Node root, int data) {
		if (root == null) {
			Node newNode = new Node(data);
			root = newNode;
			return root;
		}

		if (data < root.data) {
			root.left = addRecursive(root.left, data);
		} else if (data > root.data) {
			root.right = addRecursive(root.right, data);
		}

		return root;
	}

	public void search(int data) {
		Node searchData = searchRecursive(root, data);
		if (searchData == null) {
			System.out.println("BST is empty, no data as of yet");
		} else {
			System.out.println("Found data in BST:  " + data);
		}
	}

	public Node searchRecursive(Node root, int data) {
		if (root.data == data || root == null) {
			return root;
		} else if (data < root.data) {
			return searchRecursive(root.left, data);
		} else {
			return searchRecursive(root.right, data);
		}

	}

	public void inOrderRecursive(Node root) {
		if (root != null) {
			inOrderRecursive(root.left);
			System.out.print(root.data + " ");
			inOrderRecursive(root.right);
		}
	}

	public void inOrderPrint() {
		inOrderRecursive(root);
	}

	public int noOfNodes(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + noOfNodes(root.left) + noOfNodes(root.right);
	}

	// iterative method
	public void printLevelOrderIteratively(Node root) {
		int h = noOfNodes(root);
		for (int i = 1; i <= h; i++) {
			printLevels(root, i);
			System.out.println("");
		}
	}

	public void printLevels(Node root, int h) {
		if (root == null) {
			return;
		}
		if (h == 1) {
			System.out.print(" " + root.data);
		} else {
			printLevels(root.left, h - 1);
			printLevels(root.right, h - 1);
		}
	}

	// recursive method
	// uses Queue approach FIFO but with linked list
	public void printLevelOrderUsingQueue(Node root) {
		LinkedList q = new LinkedList();
		int levelNodes = 0;

		if (root == null) {
			return;
		}

		q.add(root);
		while (!q.isEmpty()) {
			levelNodes = q.size();
			while (levelNodes > 0) {
				Node newNode = (Node) q.remove();
				System.out.print(newNode.data + "  ");
				if (newNode.left != null) {
					q.add(newNode.left);
				}
				if (newNode.right != null) {
					q.add(newNode.right);
				}

				levelNodes--;
			}

			System.out.println("");
		}

	}

	// creates LinkedList of all the nodes at each depth
	// if you have a tree with depth D, you'll have D linked lists)
	public void depthLinkedLists(Node root) {
		LinkedList q = new LinkedList();
		int levelNodes = 0;
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			levelNodes = q.size();
			Node head = null;
			Node curr = null;
			while (levelNodes > 0) {
				Node n = (Node) q.remove();
				Node ln = new Node(n.data);
				if (head == null) {
					head = ln;
					curr = ln;
				} else {
					curr.next = ln;
					curr = curr.next;
				}
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
				levelNodes--;
			}
			adjList.add(head);
		}

	}

	public void printDepthLinkedList() {
		for (int i = 0; i < adjList.size(); i++) {
			Node head = adjList.get(i);
			while (head != null) {
				System.out.print(" -> " + head.data);
				head = head.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree bst = new BinarySearchTree();
		bst.add(45);
		bst.add(10);
		bst.add(7);
		bst.add(12);
		bst.add(90);
		bst.add(50);

		// bst.search(100);
		bst.inOrderPrint();
		int noOfNodes = bst.noOfNodes(bst.root);
		System.out.println();
		System.out.println("Height of the BST: " + noOfNodes);

		System.out.println();
		System.out.println("Iterative Level Order Printing");
		bst.printLevelOrderIteratively(bst.root);

		System.out.println("Recursive Level Order Printing");
		bst.depthLinkedLists(bst.root);
		System.out.println("Printing depth converted to LinkedList");
		bst.printDepthLinkedList();

	}
}
