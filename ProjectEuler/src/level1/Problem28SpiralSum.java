package level1;

/*
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 
 * spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed 
 * in the same way?
 * 
 * ANSWER: 669171001
 */

public class Problem28SpiralSum {
	public static void main(String[] args) {
		System.out.println("The sum of the diagonals in a 1001x1001 spiral is " + findDiagonalSum(1001) + ".");
	}
	
	public static int findDiagonalSum(int dimension) {
		//Base case
		if (dimension == 1)
			return 1;
		//Calculates the four numbers in the corners
		int outerDiagonal = 4 * (dimension * dimension) - 
				((dimension - 1) + 2 * (dimension - 1) + 3 * (dimension - 1));
		//Adds the four corners to the sum of the previous dimension spiral
		return findDiagonalSum(dimension - 2) + outerDiagonal;
	}
}
