package crackingcoding_chapter4;

import java.util.*;

/**
 * Random Node: You are implementing a binary tree class from scratch which, in
 * addition to i n s e r t , f i n d , and d e l e t e , has a method
 * getRandomNode() which returns a random node from the tree. All nodes should
 * be equally likely to be chosen. Design and implement an algorithm for
 * getRandomNode, and explain how you would implement the rest of the methods.
 **/

public class Ch4Q11RandomNode {

	// Design and implement an algorithm for getRandomNode, and
	// explain how you would implement the rest of the methods.
	TreeNode root;
	ArrayList<TreeNode> treeNodeList;

	public Ch4Q11RandomNode() {
		root = null;
		treeNodeList = new ArrayList<>();
	}

	public void insert(int data) {
		root = insertRecursive(root, data);
	}

	public TreeNode insertRecursive(TreeNode root, int data) {
		if (root == null) {
			TreeNode newNode = new TreeNode(data);
			root = newNode;
			return root;
		} else if (data < root.data) {
			root.left = insertRecursive(root.left, data);
		} else if (data > root.data) {
			root.right = insertRecursive(root.right, data);
		}

		return root;

	}

	public void find(int data) {

		TreeNode searchData = findRecursive(root, data);
		if (searchData == null) {
			return;
		} else {
			System.out.println("Data Found: " + searchData.data);
		}

	}

	public TreeNode findRecursive(TreeNode root, int data) {
		if (root == null) {
			return null;
		}

		if (data == root.data) {
			return root;
		} else if (data < root.data) {
			return findRecursive(root.left, data);
		} else if (data > root.data) {
			return findRecursive(root.right, data);
		}

		return root;
	}

	public void delete(int data) {

		deleteRecursiveMethod(root, data);
	}

	public TreeNode deleteRecursiveMethod(TreeNode root, int data) {
		if (root == null) {
			return root;
		}

		if (root.data == data) {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left == null && root.right != null) {
				root = root.right;
			} else {
				root = root.left;
			}
		} else if (data < root.data) {
			root.left = deleteRecursiveMethod(root.left, data);
		} else if (data > root.data) {
			root.right = deleteRecursiveMethod(root.right, data);
		}

		return root;

	}

	public void printTree(TreeNode root) {
		if (root == null) {
			return;
		}

		printTree(root.left);
		System.out.print(" " + root.data);
		printTree(root.right);
	}

	public void storeInOrderRecursive(TreeNode root, ArrayList<TreeNode> tList) {
		if (root == null) {
			return;
		}

		storeInOrderRecursive(root.left, tList);
		treeNodeList.add(root);
		storeInOrderRecursive(root.right, tList);

	}

	public void getRandomNode() {
		Random rand = new Random();
		int randomNum = rand.nextInt(treeNodeList.size());

		System.out.println();
		System.out.println("Random generated TreeNode is: " + treeNodeList.get(randomNum).data);
		randomNum = rand.nextInt(treeNodeList.size());
		System.out.println("Random generated TreeNode is: " + treeNodeList.get(randomNum).data);
		randomNum = rand.nextInt(treeNodeList.size());
		System.out.println("Random generated TreeNode is: " + treeNodeList.get(randomNum).data);
		randomNum = rand.nextInt(treeNodeList.size());
		System.out.println("Random generated TreeNode is: " + treeNodeList.get(randomNum).data);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ch4Q11RandomNode rN = new Ch4Q11RandomNode();
		rN.insert(100);
		rN.insert(50);
		rN.insert(200);
		rN.insert(300);
		rN.insert(49);
		rN.insert(91);
		rN.insert(24);
		rN.insert(16);

		// obj.getRandomNode();
		rN.printTree(rN.root);
		rN.storeInOrderRecursive(rN.root, rN.treeNodeList);
		rN.getRandomNode();

	}

}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
