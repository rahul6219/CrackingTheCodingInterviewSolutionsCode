package crackingcoding_chapter2;

public class Ch2Q2ReturnKthtoLast {

	// 2.2 Return Kth to Last:
	// Implement an algorithm to find the kth to last element of a singly linked
	// list.

	class LinkedList {

		private Node head;
		private Node tail;
		private int size;

		public LinkedList() {
			head = null;
			tail = null;
			size = 0;
		}

		public void insert(int x) {
			Node n = new Node(x);
			if (head == null) {
				head = n;
				tail = n;
			} else {
				tail.setNext(n);
				tail = n;
			}

			size++;

		}

		public void print() {

			if (head != null) {
				Node ptr1 = head;
				for (int i = 0; i < size; i++) {
					System.out.print(ptr1.getData() + "  ");
					ptr1 = ptr1.getNext();
				}
			}
		}

		public int getSize() {

			return this.size;
		}

		public void findKthNode() {
			
			
		}

	}

	class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

		public int getData() {
			return this.data;
		}

		public void setData(int x) {
			data = x;
		}

		public void setNext(Node n) {
			next = n;
		}

		public Node getNext() {
			return this.next;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubs
	}

}
