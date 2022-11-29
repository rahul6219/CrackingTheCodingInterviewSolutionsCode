package crackingcoding_chapter4;

import java.util.*;

public class Ch4Q8FirstCommonAncestor {

	private ArrayList<Integer> arr1;
	private ArrayList<Integer> arr2;

	public Ch4Q8FirstCommonAncestor() {
		arr1 = new ArrayList<>();
		arr2 = new ArrayList<>();
	}

	public int FCA(TreeNode root, int number1, int number2) {

		boolean num1 = findPath(root, number1, arr1);
		boolean num2 = findPath(root, number2, arr2);

		if (num1 == false || num2 == false) {
			// Either number1 or number2 does not exists in the tree
			return -1;
		}

		int i = 0;
		int commonAncestor = 0;

		while (i < arr1.size() && i < arr2.size()) {
			if (arr1.get(i) != arr2.get(i)) {
				// First non common node
				break;
			} else {
				commonAncestor = arr1.get(i);
			}
		}
		return commonAncestor;

	}


	private boolean findPath(TreeNode root, int number, ArrayList<Integer> arr) {

		if (root == null) {
			return false;
		}

		arr.add(root.data);

		if (root.data == number) {
			return true;
		}

		if (findPath(root.left, number, arr) || findPath(root.right, number, arr)) {
			return true;
		}

		arr.remove(root);
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(50);
		root.right.left.left = new TreeNode(60);
		root.right.right.left = new TreeNode(70);
		root.right.right.right = new TreeNode(80);
		
		Ch4Q8FirstCommonAncestor
	}

}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

}
