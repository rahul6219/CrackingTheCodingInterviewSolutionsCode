package crackingcoding_chapter1;

import java.util.Scanner;

public class Q8ZeroMatrix {

	private int row;
	private int col;
	private int[][] myArr;

	public Q8ZeroMatrix(int row, int col, int[][] userArray) {
		this.row = row;
		this.col = col;
		myArr = userArray;
	}

	public void rowColSetZero() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (myArr[i][j] == 0) {
					
					for(int x=0; x<row; x++)
					{
						myArr[i][x]=-1;
					}
					
					
					for(int z=0; z<col; z++)
					{
						myArr[z][j]=-1;
					}
				}
			}
		}
		
		for(int a=0; a<row; a++)
		{
			for(int b=0; b<col; b++)
			{
				if(myArr[a][b]==-1)
				{
					myArr[a][b]=0;
				}
			}
		}
	}
	

	public void printArray() {

		System.out.println();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(myArr[i][j] + "    ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int row;
		int col;

		System.out.print("Enter row size: ");
		row = in.nextInt();

		System.out.println();
		System.out.print("Enter col size: ");
		col = in.nextInt();
		System.out.println();

		int[][] userInputArray = new int[row][col];

		System.out.println("Input values into the 2D matrix");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("Row: " + i + " Col: " + j);
				System.out.println();
				userInputArray[i][j] = in.nextInt();
			}
			System.out.println();
		}

		in.close();

		Q8ZeroMatrix a = new Q8ZeroMatrix(row, col, userInputArray);
		a.printArray();
		a.rowColSetZero();
		a.printArray();

	}

}
