package crackingcoding_chapter4;

public class PrintEachLevelOfTree {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(45);
		bst.add(10);
		bst.add(7);
		bst.add(12);
		bst.add(90);
		bst.add(50);
		bst.inOrderPrint();

	}

}
