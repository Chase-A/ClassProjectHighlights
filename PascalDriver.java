package highlights;

public class PascalDriver 
{
	public static final int TRIANGLE_SIZE = 10;
	
	public static void main(String[] args)
	{
		PascalProblem triangle = new PascalProblem(TRIANGLE_SIZE);

		System.out.println("The Pascal Triangle of size " + TRIANGLE_SIZE + " is ");
		for (int row = 0; row < TRIANGLE_SIZE; row++)
		{
			for (int col = 0; col < row + 1; col++)
				System.out.print(triangle.getChoices(row, col) + " ");
			System.out.println();
		} 
	} 
} 

/*
The Pascal Triangle of size 10 is 
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
1 6 15 20 15 6 1 
1 7 21 35 35 21 7 1 
1 8 28 56 70 56 28 8 1 
1 9 36 84 126 126 84 36 9 1 
 */
