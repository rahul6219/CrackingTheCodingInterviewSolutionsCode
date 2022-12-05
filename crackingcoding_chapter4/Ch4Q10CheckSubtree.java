package crackingcoding_chapter4;

// Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
// algorithm to determine if T2 is a subtree o f Tl .
// A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2,
// That is, if you cut off the tree at node n, the two trees would be identical.

public class Ch4Q10CheckSubtree {

	// checking if tree2 is a subtree of tree1
	public boolean checkIsSubTree(TreeNode root1, TreeNode root2) {
		// if both are null
		if (root1 == null && root2 == null) {
			return true;
		} // one of them is null
		else if (root1 == null || root2 == null) {
			return false;
		}

		return (root1.data == root2.data && checkIsSubTree(root1.left, root2.left)
				&& checkIsSubTree(root1.right, root2.right));

	}

	public boolean isSubTree(TreeNode mainTree, TreeNode subTree) {

		/* base cases */
		if (subTree == null)
			return true;

		if (mainTree == null)
			return false;

		/* Check the tree with root as current node */
		if (checkIsSubTree(mainTree, subTree)) {
			return true;
		}

		return checkIsSubTree(mainTree.left, subTree) || checkIsSubTree(mainTree.right, subTree);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root1 = new TreeNode(20);
		root1.left = new TreeNode(10);
		root1.right = new TreeNode(40);
		root1.left.left = new TreeNode(200);
		root1.left.right = new TreeNode(100);
		root1.right.right = new TreeNode(60);

		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(200);
		root2.right = new TreeNode(100);

		Ch4Q10CheckSubtree obj = new Ch4Q10CheckSubtree();
		boolean val = obj.checkIsSubTree(root1, root2);
		System.out.println(val);
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