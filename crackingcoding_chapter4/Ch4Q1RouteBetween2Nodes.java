package crackingcoding_chapter4;

public class Ch4Q1RouteBetween2Nodes {

	private int vertexSize;
	private int[][] directedGraphMatrix;

	public Ch4Q1RouteBetween2Nodes(int vertexSize, int[][] directedGraphMatrix) 
	{
		this.vertexSize = vertexSize;
		this.directedGraphMatrix=directedGraphMatrix;
	}

	public void printGraphMatrix() {
		for (int i = 0; i < directedGraphMatrix.length; i++) 
		{
			for (int j = 0; j < directedGraphMatrix.length; j++) 
			{
				System.out.print(directedGraphMatrix[i][j]);
			}

			System.out.println();
		}
	}
	
	public void routeBtw2Nodes()
	{
		
		System.out.println("Printing vertices for whom the route exists for: ");
		for(int i=0; i<directedGraphMatrix.length; i++)
		{
			for(int j=0; j< directedGraphMatrix.length; j++)
			{
				if(directedGraphMatrix[i][j]==1 && directedGraphMatrix[j][i]==1)
				{
					System.out.print("Route b/w the following nodes exist: "+i + " and "+ " "+j);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] m= {{0,1,1,0},{1,0,0,0},{0,1,0,0},{0,1,0,0}};
		
		Ch4Q1RouteBetween2Nodes obj= new Ch4Q1RouteBetween2Nodes(4,m);
		obj.printGraphMatrix();
		obj.routeBtw2Nodes();

	}

}
