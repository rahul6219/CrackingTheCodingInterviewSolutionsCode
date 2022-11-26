package crackingcoding_chapter4;
import java.util.*;


public class Ch4Q2MinimalTree {
	
	//Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
	//to create a binary search tree with minimal height.
	
	public class BSTNode{
		
		int data;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(int data)
		{
			this.data=data;
		}
	}
	
	public BSTNode createBinarySearchWithMinimalHeight(int arr[],int start, int end)
	{
		if(start>end)
		{
			return null;
		}
		
		int mid=( start + end ) /2;
		BSTNode root=new BSTNode(arr[mid]);
		root.left=createBinarySearchWithMinimalHeight(arr,start ,mid-1);
		root.right=createBinarySearchWithMinimalHeight(arr,mid+1,end);
		
		return root;
	}
	
	public void printBST(BSTNode root)
	{
		if(root!=null)
		{
			printBST(root.left);
			System.out.print(root.data+ "  " );
			printBST(root.right);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in= new Scanner(System.in);
		System.out.print("Specify size of array: ");
		int arraySize=in.nextInt();
		int[] myArr= new int[arraySize];
		int userInput;
		
		for(int a=0; a<arraySize; a++)
		{
			System.out.print("Enter element at index position :"+a + " :: " );
			userInput=in.nextInt();
			myArr[a]=userInput;
			System.out.println();
		}
		
		in.close();
		
		//Sort the array in increasing order
		int temp;
		
		for(int i=0; i<myArr.length-1; i++)
		{
			for(int j=i+1; j<myArr.length; j++)
			{
				if(myArr[i]>myArr[j]) //this will perform swap
				{
					temp=myArr[i];
					myArr[i]=myArr[j];
					myArr[j]=temp;
				}
			}
		}
		
		for(int var:myArr)
		{
			System.out.print(var+ " ");
		}
		
		Ch4Q2MinimalTree obj= new Ch4Q2MinimalTree();
		BSTNode startingRoot=obj.createBinarySearchWithMinimalHeight(myArr, 0, arraySize-1);
		
		System.out.println();
		System.out.println("Printing my BST tree");
		obj.printBST(startingRoot);
		

	}

}
