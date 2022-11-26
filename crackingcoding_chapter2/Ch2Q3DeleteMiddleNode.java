package crackingcoding_chapter2;

import LinkedListCode.LinkedList;
import LinkedListCode.Node;
import crackingcoding_chapter2.*;

public class Ch2Q3DeleteMiddleNode {

	/*
	 * Delete Middle Node: Implement an algorithm to delete a node in the middle
	 * (i.e., any node but the first and last node, not necessarily the exact
	 * middle) of a singly linked list, given only access to that node.
	 */
	public void deleteMiddleNode(LinkedList myList, int dataToBeDeleted) 
	{
		if(myList.getHead()==null || myList.getTail()==null)
		{
			System.out.println();
			System.out.println();
			System.out.println("List is empty, cannot delete middle");
			return;
		}
		else if(myList.getHead().getData()==dataToBeDeleted || myList.getTail().getData()==dataToBeDeleted)
		{
			System.out.println();
			System.out.println();
			System.out.println("Cannot delete first or last node : "+ dataToBeDeleted);
			return;
		}
		else
		{
			
			System.out.println();
			System.out.println();
			
			Node temp1=myList.getHead();
			
			while(temp1.getNext().getData()!=dataToBeDeleted)
			{
				temp1=temp1.getNext();
			}
			
			temp1.setNext(temp1.getNext().getNext());
		}
		myList.print();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.print();
		
		Ch2Q3DeleteMiddleNode d= new Ch2Q3DeleteMiddleNode();
		d.deleteMiddleNode(list, 40);
		
	}

}
