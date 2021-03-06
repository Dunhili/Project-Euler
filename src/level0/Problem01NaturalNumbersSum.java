package level0;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * ANSWER: 233168
*/

public class Problem01NaturalNumbersSum {
	public static void main(String[] args) {
		int sum = 0;
		int limit = 1000;
		for (int i = 1; i < limit; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println("Sum for natural numbers below " + limit + " is : " + sum + ".");
	}
}
