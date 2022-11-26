package crackingcoding_chapter2;

import LinkedListCode.LinkedList;
import LinkedListCode.Node;
import crackingcoding_chapter2.*;

public class Ch2Q1RemoveDuplicates {

	// remove duplicates from unsorted linkedlist
	public Ch2Q1RemoveDuplicates(LinkedList list) {
		Node temp1 = list.getHead();
		Node temp2 = null;
		Node dup = null;
		
		

	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.insert(12);
		list.insert(11);
		list.insert(12);
		list.insert(21);
		list.insert(41);
		list.insert(43);
		list.insert(21);
		list.insertAtHead(100);
		list.insertAtTail(300);
		list.print();

	}

}
