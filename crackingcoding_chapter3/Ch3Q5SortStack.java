package crackingcoding_chapter3;

import java.util.*;

public class Ch3Q5SortStack {

	// Big to small order
	// This function return the sorted stack
	public Stack<Integer> sortStack(Stack<Integer> stack1) {
		Stack<Integer> stack2 = new Stack<Integer>();

		while (!stack1.isEmpty()) {
			int x = stack1.pop();

			while (!stack2.isEmpty() && stack2.peek() < x) {
				stack1.push(stack2.pop());
			}
			stack2.push(x);
		}

		System.out.println(stack2.peek());
		return stack2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> myStack = new Stack<Integer>();

		// input: [34, 3, 31, 98, 92, 23]

		myStack.push(34);
		myStack.push(3);
		myStack.push(31);
		myStack.push(98);
		myStack.push(92);
		myStack.push(23);
		System.out.println(myStack);
		myStack.pop();
		System.out.println(myStack);
		Ch3Q5SortStack a = new Ch3Q5SortStack();

		System.out.println(a.sortStack(myStack));

	}

}
