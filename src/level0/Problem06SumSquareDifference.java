package level0;

/*
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers 
 * and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural 
 * numbers and the square of the sum.
 * 
 * ANSWER: 25164150
 */

public class Problem06SumSquareDifference {
	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 1; i <= 100; i++)
			sum1 += i * i;
		
		
		sum2 = (100 * 101 / 2) * (100 * 101 / 2);
		System.out.println("Difference is " + (sum2 - sum1));
	}
}
