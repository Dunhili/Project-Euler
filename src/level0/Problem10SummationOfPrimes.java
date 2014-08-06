package level0;

import utils.HelperMethods;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 * 
 * ANSWER: 142913828922
 */

public class Problem10SummationOfPrimes {
	public static void main(String[] args) {
		int upperLimit = 2000000;
		long sum = 0;
		
		for (int i = 2; i < upperLimit; i++) {
			if (HelperMethods.isPrime(i)) {
				sum += i;
			}
		}
		
		System.out.println("Sum of all primes from 1 to 2,000,000 is " + sum + ".");
	}
}
