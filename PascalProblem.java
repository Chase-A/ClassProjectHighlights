/*
 * Student First Name: Chase
 * Student Last Name: Almy
 * Student BU Number: U64493103
 * Honor Code: Honor Code: I pledge that this program represents my own program code and that I have coded on my own. 
 * I have also read the collaboration policy on the course syllabus for
 * CS 112 and my program adheres and is consistent with the course syllabus.
 */
package highlights;
import java.util.ArrayList;
import java.util.List;
public class PascalProblem 
{
	private ArrayList<ArrayList<Integer>> triangle;
	private static final int DEFAULT_ROWS = 10;

	/*
	 * We have completed this method for you
	 */
	public PascalProblem()
	{
		this(DEFAULT_ROWS);
	} // end default constructor

	/** Precondition: numberOfRows > 0 */
	/*
	 * We have completed this method for you
	 */
	public PascalProblem(int numberOfRows)
	{
		triangle = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<>();
		
		// First row contains 1
		row.add(0, 1);
		triangle.add(0, row);

		for (int rowIndex = 1; rowIndex < numberOfRows; rowIndex++)
			triangle.add(rowIndex, getNextRow(rowIndex));
	} 


	public ArrayList<Integer> getNextRow(int rowIndex)
	{
		ArrayList<Integer> nextRow = new ArrayList<Integer>();
		nextRow.add(1);
		
		for(int i = 0; i < rowIndex - 1; i++) {
			Integer add1 = triangle.get(rowIndex - 1).get(i);
			Integer add2 = triangle.get(rowIndex - 1).get(i + 1);

			int add = add1 + add2;
			nextRow.add(add);
		}
		nextRow.add(1);
		return nextRow;
	} 

	public ArrayList<Integer> getRow(int rowIndex)
	{
		return triangle.get(rowIndex);
	} 


	public int getChoices(int n, int k)
	{
		ArrayList<Integer> row = getRow(n);
		return row.get(k);
	} 
} 
