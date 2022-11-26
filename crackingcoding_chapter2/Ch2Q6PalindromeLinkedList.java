package crackingcoding_chapter2;

import java.util.ArrayList;
import crackingcoding_chapter2.*;
import java.util.*;

public class Ch2Q6PalindromeLinkedList {

	public boolean isPalindrome(MyLinkedList myList, MyStack myStack) {

		Node temp = myList.getHead();
		char tempData = myStack.pop();
		boolean x=true;
		
		while (temp != null) {
			
			if(temp.getData()==tempData)
			{
				temp = temp.getNext();
				tempData = myStack.pop();
				x=true;
			}
			else
			{
				System.out.println("The words are NOT Palindromes");
				x=false;
				return x;
			}
			
		
			System.out.println("The words are palindromes");
			return x;
		}

		System.out.println("The words are palindromes");
		return true;

	}

	public class MyStack {

		private ArrayList<Character> charList;

		public MyStack() {
			charList = new ArrayList<Character>();
		}

		public void push(char data) {
			charList.add(data);
		}

		public char pop() {
			if (charList.size() == 0) {
				System.out.println("Cannot pop, list is empty");
				return 'x';
			} else {
				char popVal = charList.get(charList.size() - 1);
				charList.remove(charList.size() - 1);
				return popVal;
			}
		}

		public boolean isEmpty() {
			if (charList.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public int getStackSize() {
			return charList.size();
		}

		public char peek() {
			if (charList.size() == 0) {
				return 'x';
			} else {
				return charList.get(charList.size() - 1);
			}
		}

	}

	public class MyLinkedList {

		private Node head;
		private Node tail;

		public MyLinkedList() {
			head = null;
			tail = null;
		}

		public Node getHead() {
			if (head == null) {
				return null;
			} else {
				return head;
			}
		}

		public void insert(char d) {
			Node newNode = new Node(d);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				newNode.setNext(head);
				head = newNode;
			}
		}

		public void print() {
			Node t = head;
			while (t != null) {
				System.out.print(t.getData() + "  ");
				t = t.getNext();
			}
		}

	}

	public class Node {

		private char data;
		private Node next;

		public Node(char data) {
			this.data = data;
			this.next = null;
		}

		public void setData(char data) {
			this.data = data;
		}

		public char getData() {
			return this.data;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node n) {
			this.next = n;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ch2Q6PalindromeLinkedList myList = new Ch2Q6PalindromeLinkedList();
		MyLinkedList mL = myList.new MyLinkedList();
		MyStack mS = myList.new MyStack();

		mL.insert('m');
		mL.insert('a');
		mL.insert('d');
		mL.insert('a');
		mL.insert('m');

		mS.push('m');
		mS.push('a');
		mS.push('a');
		mS.push('a');
		mS.push('m');

		myList.isPalindrome(mL, mS);

	}

}
