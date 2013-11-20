package level0;

import java.math.BigInteger;

/*
 * Starting in the top left corner of a 2x2 grid, there are 6 routes 
 * (without backtracking) to the bottom right corner.
 * 
 * How many routes are there through a 20x20 grid?
 * 
 * ANSWER: 137846528820
 */

public class Problem15MatrixRoute {
	public static void main(String[] args) {
		System.out.println("Number of routes for a 20x20 is " + PascalsTriangle(2 * 20, 20) + ".");
	}
	
	//Gets the 2 * n row and the n column
	private static BigInteger PascalsTriangle (int n, int k) {
		return Factorial(n).divide(Factorial(k).multiply(Factorial(k)));
	}
	
	private static BigInteger Factorial(int N) {
		if (N <= 1)
			return BigInteger.ONE;
		return new BigInteger(N + "").multiply(Factorial(N - 1));
	}
}
