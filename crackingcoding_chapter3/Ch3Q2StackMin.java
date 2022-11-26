package crackingcoding_chapter3;

public class Ch3Q2StackMin {

	private int[] arr;
	private int top;
	private int size;
	private int minElement;

	public Ch3Q2StackMin(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
		minElement = -1;
	}

	public void push(int x) {
		if (top == size - 1) {
			System.out.println("Cannot push onto stack, stack is full");
			return;
		} else {
			top = top + 1;
			arr[top] = x;
		}
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack is empty, cannot pop");
			return -1;
		} else {
			int element = arr[top];
			top--;
			return element;
		}
	}

	public int peek() {
		if (top == -1) {
			System.out.println("Cannot peek, empty stack");
			return -1;
		} else {
			System.out.println("peek called: " + arr[top]);
			return arr[top];
		}
	}

	public boolean isEmpty() {
		if (top == -1) {
			System.out.println("**Stack is empty**");
			return true;
		}

		System.out.println("**Stack is not empty**");
		return false;
	}

	public boolean isFull() {
		if (top == size - 1) {
			System.out.println("**Stack is full**");
			return true;
		}

		System.out.println("**Stack is not full**");
		return false;
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("Cannot PRINT, stack is empty");
			return;
		}

		for (int a = 0; a <= top; a++) {
			System.out.print(arr[a] + "  ");
		}

	}

	public int minElementInStack() {

		if (top==-1) {
			System.out.println("The stack is empty, min element does not exist.");
			return -1;
		}

		int min = arr[0];
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] < min) {
				min = arr[x];
			}
		}
		
		System.out.println();
        System.out.println("Smallest element present in given array: " + min); 
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ch3Q2StackMin myStack = new Ch3Q2StackMin(5);
		myStack.isEmpty();
		myStack.isFull();
		myStack.push(10);
		myStack.push(200);
		myStack.push(3);
		myStack.push(50);
		myStack.push(4);
		myStack.minElementInStack();
		myStack.printStack();


	}

}
