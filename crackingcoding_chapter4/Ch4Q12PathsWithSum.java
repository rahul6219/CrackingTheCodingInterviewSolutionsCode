package crackingcoding_chapter4;

import java.util.ArrayList;

/**
 * Paths with Sum: You are given a binary tree in which each node contains an
 * integer value (which might be positive or negative). Design an algorithm to
 * count the number of paths that sum to a given value. The path does not need
 * to start or end at the root or a leaf, but it must go downwards (traveling
 * only from parent nodes to child nodes).
 * 
 */
public class Ch4Q12PathsWithSum {

	private static ArrayList<Integer> aList;
	private static int countPaths;

	public Ch4Q12PathsWithSum() {
		aList = new ArrayList<Integer>();
		countPaths = 0;
	}

	public static void findAllPaths(TreeNode x, int desiredSum) {

		if (x == null) {
			return;
		}

		aList.add(x.data);
		findAllPaths(x.left, desiredSum);
		findAllPaths(x.right, desiredSum);

		int sum = 0;

		for (int i = aList.size() - 1; i >= 0; i--) {
			sum = sum + aList.get(i);

			if (sum == desiredSum) {
				printDesiredSum(aList, i);
				countPaths++;
			}
		}

		aList.remove(aList.size() - 1);

	}

	public static void pathCount() {
		System.out.println();
		System.out.println("Number of paths that exist: " + countPaths);
	}

	public static void printDesiredSum(ArrayList<Integer> aList2, int i) {

		for (int j = i; j < aList2.size(); j++) {
			System.out.print(aList2.get(j) + "  ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(1);

		root.right = new TreeNode(-1);
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(2);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(6);

		int desiredSum = 5;
		Ch4Q12PathsWithSum a = new Ch4Q12PathsWithSum();
		a.findAllPaths(root, desiredSum);
		pathCount();

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
