package crackingcoding_chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

// Implement a function to check if a binary tree is a binary search tree.
public class Ch4Q5ValidateBST {

	ArrayList<Integer> treeNodeArrayList;

	public Ch4Q5ValidateBST() {
		treeNodeArrayList = new ArrayList<>();
	}

	// Implement a function to check if a binary tree is a binary search tree.

	public void InOrderRecursive(TreeNode root) {
		if (root == null) {
			return;
		} else {

			InOrderRecursive(root.left);
			treeNodeArrayList.add(root.data);
			// System.out.print(root.data + " ");
			InOrderRecursive(root.right);
		}
	}

	public ArrayList<Integer> sortLeftSubTree(TreeNode root) {
		ArrayList<Integer> dataArr1 = new ArrayList<Integer>();
		int indexOfLeftSubTree = treeNodeArrayList.indexOf(root.data);

		for (int i = 0; i < indexOfLeftSubTree; i++) {
			dataArr1.add(treeNodeArrayList.get(i));
		}

		// System.out.println("Index of tree node: "+indexOfLeftSubTree);
		int temp;
		for (int i = 0; i < indexOfLeftSubTree - 1; i++) {
			for (int j = i + 1; j < indexOfLeftSubTree; j++) {
				if (dataArr1.get(i) > dataArr1.get(j)) {
					// swap
					temp = dataArr1.get(i);
					dataArr1.set(i, dataArr1.get(j));
					dataArr1.set(j, temp);
				}
			}
		}

		System.out.println();
		System.out.println("Printing dataArr1");
		for (int i = 0; i < dataArr1.size(); i++) {
			System.out.print(dataArr1.get(i) + "  ");
		}

		return dataArr1;
	}

	public ArrayList<Integer> sortRightSubTree(TreeNode root) {
		ArrayList<Integer> dataArr2 = new ArrayList<Integer>();
		int indexOfRightSubTree = treeNodeArrayList.indexOf(root.data);

		for (int i = indexOfRightSubTree + 1; i < treeNodeArrayList.size(); i++) {
			dataArr2.add(treeNodeArrayList.get(i));
		}

		// System.out.println("Index of tree node: "+indexOfLeftSubTree);
		int temp;
		for (int i = 0; i < indexOfRightSubTree - 1; i++) {
			for (int j = i + 1; j < indexOfRightSubTree; j++) {
				if (dataArr2.get(i) > dataArr2.get(j)) {
					// swap
					temp = dataArr2.get(i);
					dataArr2.set(i, dataArr2.get(j));
					dataArr2.set(j, temp);
				}
			}
		}

		System.out.println();
		System.out.println("Printing dataArr2");
		for (int i = 0; i < dataArr2.size(); i++) {
			System.out.print(dataArr2.get(i) + "  ");
		}

		return dataArr2;
	}

	public void isBST(TreeNode root) {
		ArrayList<Integer> left = sortLeftSubTree(root);
		ArrayList<Integer> right = sortRightSubTree(root);

		int greatestInLeftSubTree = left.get(left.size() - 1);
		int leastInRightSubTree = right.get(0);

		System.out.println();
		if (greatestInLeftSubTree < root.data && leastInRightSubTree < root.data) {
			System.out.println("Is a BST Tree");
		} else {
			System.out.println("Is not a BST tree");
		}

	}

	public void printArrayList() {
		for (int i = 0; i < treeNodeArrayList.size(); i++) {
			System.out.print(treeNodeArrayList.get(i) + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(15);
		tree.left.left = new TreeNode(12);
		tree.left.right = new TreeNode(25);
		tree.left.right.left = new TreeNode(10);

		tree.right = new TreeNode(30);
		tree.right.left = new TreeNode(28);
		tree.right.left.left = new TreeNode(19);
		tree.right.right = new TreeNode(40);

		tree.printTree(tree);
		Ch4Q5ValidateBST treeObj = new Ch4Q5ValidateBST();
		treeObj.InOrderRecursive(tree);

		System.out.println("\nPrinting ArrayList data");
		treeObj.printArrayList();
		treeObj.sortLeftSubTree(tree);
		treeObj.sortRightSubTree(tree);
		treeObj.isBST(tree);

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

	public void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.print(root.data + "  ");
		printTree(root.right);
	}

}